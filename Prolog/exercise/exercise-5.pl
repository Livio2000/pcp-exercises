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





%5 A
?- op(1150, xfx, mother).

%5 B
?- op(1150, xfx, offspring).