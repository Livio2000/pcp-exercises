fib(0, 0).
fib(1, 1).
fib(N, F) :-
	N > 0,
	N1 is N - 1, N2 is N	- 2,
	fib(N1, F1), fib(N2, F2),
	F is F1 + F2.

fib_tr(N, F) :- fib_tr(N, 0, 1, F).
fib_tr(0, A, _, A).
fib_tr(N, A, B, F) :-
	N1 is N - 1,
	N1 >= 0,
	Sum is A + B,
	fib_tr(N1, B, Sum, F).

:- dynamic fib_as/2.

fib_as(0, 0).
fib_as(1, 1).
fib_as(N, F) :-
	N > 1,
	N1 is N-1,
	N2 is N-2,
	fib_as(N1, F1),
	fib_as(N2, F2),
	F is F1+F2,
	asserta(fib_as(N, F)).

:- dynamic bigger/2.

bigger(elephant, horse).
bigger(horse, dog).
bigger(horse, sheep).

is_bigger(X, Y) :- bigger(X, Y).
is_bigger(X, Y) :- bigger(X, Z), is_bigger(Z, Y).


mem(X, [X | _Tail]).
mem(X, [_ | Tail]) :- mem(X, Tail).


conc([], L, L).
conc([X | L1], L2, [X | L3]) :-
	conc(L1, L2, L3).


mem_c(X, L) :- conc(_, [X | _], L).
