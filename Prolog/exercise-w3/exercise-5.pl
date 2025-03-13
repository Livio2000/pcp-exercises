warn(T) :- T < 80, write('Temperatur ok'), !.
warn(T) :- T < 100, write('Temperatur sehr warm'), !.
warn(_) :- write('Temperatur zu heiss').




warn1(T) :- T < 80, write('Temperatur ok').
warn1(T) :- T < 100, T > 79, write('Temperatur sehr warm').
warn1(T) :- T > 99, write('Temperatur zu heiss').



%warn ist besser da es bei allen werten unter 80 nur die erste
%regel matched und direkt beendet wird. Bei warn1 werden immer
%alle regeln durchgegangen was inneffizient ist.