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