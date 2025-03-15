%Implementieren Sie die Relation set_difference(Set1, Set2, SetDifference), bei welcher in
%SetDifference alle Elemente sind, welche in Set1 sind, jedoch nicht in Set2. Alle drei Mengen werden
%dabei als Listen repräsentiert.

%set_difference([a, b, c, d], [b, d, e, f], [a, c]).
%set_difference([1, 2, 3, 4, 5, 6], [2, 4, 6], L).


set_difference([], _, []).
set_difference([H | T], L, [H | SetDifference]) :- 
    \+ member(H, L),                    % Falls H nicht in L ist, wird es behalten
    !,                                  % Cut: Verhindert, dass die nächste Klausel ausgeführt wird
    set_difference(T, L, SetDifference).

set_difference([H | T], L, SetDifference) :- 
    set_difference(T, L, SetDifference).    % Falls H in L ist, wird es verworfen


%Basisfall: Ist Set1 leer ([]), ist auch die Differenz leer.