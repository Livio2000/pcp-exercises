%a)
%L = [_, _, _], member(a, L), member(b, L), member(c, L).
% z.b. -> L = [_, _, _], member(a, L), !, member(b, L), !, member(c, L).
%
%Einfachste Lösung:
%L = [_, _, _], member(a, L), member(b, L), member(c, L), !.
%ist sinnvoll, weil sie sicherstellt, dass eine vollständige Lösung 
%gefunden wird, aber kein weiteres Backtracking stattfindet,
%um andere Permutationen zu erzeugen.


%b)
%green cut
%Die deklarative Bedeutung wird nicht verändert, nur die prozedurale
%
%red cut
%die deklarative Bedeutung wird verändert