?- use_module(library(clpr)).

fib_clp(N, F) :- { N = 0, F = 0 }.
fib_clp(N, F) :- { N = 1, F = 1 }.
fib_clp(N, F) :-
	{ N >= 2, F = F1+F2, N1 = N-1, N2 = N-2 },
	fib_clp(N1, F1),
	fib_clp(N2, F2).


%a) Wie manifestiert sich dieses Problem in SWI-Prolog?
%Rekursionsbasis wird nie erfüllt sein da es keine Fibonacci Zahl z.b. 5 gibt. 
%Darum wird immer weiter gesucht bis ein stack overflow passiert.



%b) Wieso tritt dieses Problem auf? 
%Weil die Rekursionsbasis nie erfüllt wird. 
%Es gibt unendlich viele Fibonacci zahlen die berechnet werden könnten.



%c) Lässt sich das oben beschriebene Problem einfach beheben? Falls ja: Modifizieren Sie das Prädikat
%entsprechend und testen Sie das neue Prädikat. Falls Nein: Begründen Sie Ihre Antwort.
%
%Nein, ausser man schränkt den Zahlbereich ein.