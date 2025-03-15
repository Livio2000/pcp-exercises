female(mary). female(liz). female(mia). female(tina). female(ann). female(sue).% all females
male(mike). male(jack). male(fred). male(tom). male(joe). male(jim). % all males
parent(mary, mia). parent(mary, fred). parent(mary, tina). % all childern of mary
parent(mike, mia). parent(mike, fred). parent(mike, tina). % all children of mike
parent(liz, tom). parent(liz, joe). % allchildern of liz
parent(jack, tom). parent(jack, joe). % all childern of jack
parent(mia, ann). % all childern of mia
parent(tina, sue). parent(tina, jim). % all childern of tina
parent(tom, sue). parent(tom, jim). % all childern of tom


%A
mother(M, C) :- female(M), parent(M, C).
father(F, C) :- male(F), parent(F, C).
%wie alle Kinder von Mary heissen? -> mother(mary, X).


%B
sibling(A, B) :- parent(P, A), parent(P, B).
 

%C
grandmother(GM, C) :- mother(GM, P), parent(P, C).
%alle Grossmütter von jim -> grandmother(X, jim).


%D
offspring(O, A) :- parent(A, O).
offspring(O, A) :- parent(A, P), offspring(O, P).


?- use_module(library(clpfd)).

sudoku_solver(Rows) :-
  append(Rows, Vs), Vs ins 1..9,
  maplist(all_distinct, Rows),
  transpose(Rows, Columns),
  maplist(all_distinct, Columns),
  Rows = [A,B,C,D,E,F,G,H,I],
  blocks(A, B, C), blocks(D, E, F), blocks(G, H, I),
  maplist(label, Rows).

blocks([], [], []).
blocks([A,B,C|Bs1], [D,E,F|Bs2], [G,H,I|Bs3]) :-
  all_distinct([A,B,C,D,E,F,G,H,I]),
  blocks(Bs1, Bs2, Bs3).

replace_0([], []).
replace_0([0 | T], [_ | R]) :-
  replace_0(T, R).
replace_0([H | T], [H | R]) :-
  H \= 0,
  replace_0(T, R).


?- use_module(library(http/http_client)).
?- use_module(library(http/http_json)).

%solve(relationship, 326).
%solve(sudoku, 326).

get_problem(Problem, Id, Reply) :- 
    string_concat('http://localhost:16316/problem/', Problem, BaseUrl),
    string_concat(BaseUrl, '/', BaseUrl2),
    string_concat(BaseUrl2, Id, Url),
    http_get(Url, Reply, [json_object(dict)]).
  
send_solution(Problem, Id, Solution, Reply) :-
    string_concat('http://localhost:16316/problem/', Problem, Url),
    http_post(Url, json(json([solution=Solution, id=Id])), Reply, []).

relationship(JSONReply, Solution) :-
    atom_string(FirstPerson, JSONReply.firstPerson),
    atom_string(SecondPerson, JSONReply.secondPerson),
    atom_string(Relationship, JSONReply.relationship),
    (call(Relationship, FirstPerson, SecondPerson) -> Solution = "true" ; Solution = "false").
  
sudoku(JSONReply, Solution) :-
    Problem = JSONReply.sudoku,
    maplist(replace_0, Problem, Solution),
    Solution = [A,B,C,D,E,F,G,H,I],
    sudoku_solver([A,B,C,D,E,F,G,H,I]), !.
  
call_problem(Problem, Reply, Solution) :-
    call(Problem, Reply, Solution).
  
solve(Problem, Id) :-
    get_problem(Problem, Id, Reply),
    call_problem(Problem, Reply, Solution),
    send_solution(Problem, Id, Solution, _).


/*
    Puzzle = [
        [5,3,_,_,7,_,_,_,_],
        [6,_,_,1,9,5,_,_,_],
        [_,9,8,_,_,_,_,6,_],
        [8,_,_,_,6,_,_,_,3],
        [4,_,_,8,_,3,_,_,1],
        [7,_,_,_,2,_,_,_,6],
        [_,6,_,_,_,_,2,8,_],
        [_,_,_,4,1,9,_,_,5],
        [_,_,_,_,8,_,_,7,9]
        ],
        Puzzle = [A,B,C,D,E,F,G,H,I],
        sudoku([A,B,C,D,E,F,G,H,I]).
*/