
:- dynamic bigger/2.

bigger(elephant, horse).
bigger(horse, dog).
bigger(horse, sheep).

is_bigger(X, Y) :- bigger(X, Y).
is_bigger(X, Y) :- bigger(X, Z), is_bigger(Z, Y).

ib_1(X, Y) :- bigger(X, Z), ib_1(Z, Y).
ib_1(X, Y) :- bigger(X, Y).

ib_2(X, Y) :- ib_2(Z, Y), bigger(X, Z).
ib_2(X, Y) :- bigger(X, Y).

f(a).
f(b).
g(c).
g(X) :- f(X).

grandfather(X, Y) :-        % head
	father(X, Z),       % body, goal 1
	parent(Z, Y).       % body, goal 2

rich(tom).		    % fact 1
nice(mary).		    % fact 2
interesting(X) :-	    % rule 1
	rich(X);	    % rule 1, goal 1 OR
	nice(X).            % rule 1, goal 2

interesting1(X) :- rich(X); nice(X).    % disjunction
interesting2(X) :- rich(X).             % rule 1 „rich“
interesting2(X) :- nice(X).             % rule 2 „nice“

p(X):- a(X).
p(X):- b(X), !, c(X).
p(X):- d(X).
a(1).
b(2). b(3).
c(2). c(3).
d(4).

u(1).
u(X) :- v(X).
u(2).
v(_X) :- !, write("CUT").

max(X, Y, X) :- X >= Y.
max(X, Y, Y) :- X < Y.

max1(X, Y, X) :- X >= Y, !.
max1(_X, Y, Y).

max2(X, Y, Z) :- X >= Y, !, X = Z.
max2(_X, Y, Y).

mem(X, [X | _]).
mem(X, [_| Tail]) :- mem(X, Tail).

% mem(X, [a, b, c]).

mem_det(X, [X | _]) :- !.
mem_det(X, [_| Tail]) :- mem_det(X, Tail).

% mem_det(X, [a, b, c]).

r(b).
r(a) :- !.
r(c).
