bigger(elephant, horse).
bigger(horse, dog).
bigger(horse, sheep).

is_bigger(X, Y) :- bigger(X, Y).
is_bigger(X, Y) :- bigger(X, Z), is_bigger(Z, Y).

is_smaller(X, Y) :- is_bigger(Y, X).

vertical(line(point(X,_), point(X,_))).
horizontal(line(point(_,Y), point(_,Y))).

father(tom, mary).
parent(mary, sue).

grandfather(X, Y) :-        % head
	father(X, Z),       % body, goal 1
	parent(Z, Y).       % body, goal 2

f(a).
f(b).
g(a).
g(b).
h(b).
k(X) :- f(X), g(X), h(X).
