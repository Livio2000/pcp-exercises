%A
add_tail(X, [], [X]).
add_tail(X, [H|T], [H|L1]) :-
    add_tail(X, T, L1).

%Erklärung:
%Erste Zeile (add_tail(X, [], [X]))
%Wenn die Eingabeliste L leer ist ([]), dann besteht die Ergebnisliste L1 nur aus X.
%Zweite Zeile (add_tail(X, [H|T], [H|L1]))
%Falls L nicht leer ist, nehmen wir das erste Element H und fügen es zur neuen Liste L1 hinzu.
%Danach wird add_tail/3 rekursiv für den Rest der Liste T aufgerufen, bis der Basisfall erreicht ist.


%B
del([], _, []).
del([X|T], X, L) :- !, del(T, X, L).
del([H|T], X, [H|L]) :- del(T, X, L).

%Falls das erste Element der Liste X ist, wird es ignoriert.
%Das Prädikat wird rekursiv mit dem Rest der Liste T aufgerufen.
%Dadurch wird X aus der Liste entfernt.
%Falls H nicht gleich X ist, wird H in L1 übernommen.
%del/3 wird dann rekursiv für den Rest der Liste T aufgerufen.


%C
mem_d(X, L) :- del(L, X, L1), L \= L1.

%del(L, X, L1): Versucht, X aus L zu entfernen, das Ergebnis ist L1.
%L \= L1: Falls L und L1 unterschiedlich sind, dann war X in L enthalten (da del/3 etwas entfernt hat).
%Falls X nicht in L war, bleibt L1 gleich L, und der Vergleich L \= L1 schlägt fehl, wodurch mem_d/2 false ergibt.


%D)
rev_acc([], A, A).
rev_acc([H | T], A, R) :- rev_acc(T, [H | A], R).


%E)
rev(L, R) :- rev_acc(L, [], R).