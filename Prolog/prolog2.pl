word(d,o,g).	   word(r,u,n).	      word(t,o,p).
word(f,i,v,e).     word(f,o,u,r).     word(l,o,s,t).      word(m,e,s,s).     word(u,n,i,t).
word(b,a,k,e,r).   word(f,o,r,u,m).   word(g,r,e,e,n).    word(s,u,p,e,r).
word(p,r,o,l,o,g). word(v,a,n,i,s,h). word(w,o,n,d,e,r).  word(y,e,l,l,o,w).

solution(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16) :-
	word(L1,L2,L3,L4,L5),			%  Top horizontal word
	word(L9,L10,L11,L12,L13,L14),		%  Second horizontal word
	word(L1,L6,L9,L15),			%  First vertical word
	word(L3,L7,L11),			%  Second vertical word
	word(L5,L8,L13,L16).			%  Third vertical word

% solution(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16).


n(red, green).		n(red, blue).
n(green, red).		n(green, blue).
n(blue, red).		n(blue, green).

colors(CH, A, D, I, F, B, N) :-
	CH = red,                               % Switzerland must be red
	n(CH, A), n(CH, I), n(CH, F), n(CH, D), % All neighbors of Switerland
	n(A, D), n(A, I),			% All neighbors of Autria (except those already mentioned)
	n(I, F),                                % All neighbors of Italy (except those already mentioned)
	n(F, B),                                % All neighbors of France (except those already mentioned)
	n(D, B), n(D, N),			% All neighbors of Germany (except those already mentioned)
	n(B, N).			        % All neighbors of Belgium (except those already mentioned)

% colors(CH, A, D, I, F, B, N).

bigger(elephant, horse).
bigger(horse, dog).
bigger(horse, sheep).

is_bigger(X, Y) :- bigger(X, Y).
is_bigger(X, Y) :- bigger(X, Z), is_bigger(Z, Y).

% op(1150, xfx, is_bigger).

fak(0, 1).
fak(N, F) :-
	N > 0,
	N1 is N - 1,
	fak(N1, F1),
	F is N * F1.

fib(0, 0).
fib(1, 1).
fib(N, F) :-
	N > 0,
	N1 is N - 1,
    N2 is N - 2,
	fib(N1, F1),
	fib(N2, F2),
	F is F1 + F2.
