mult(0, _, 0).
mult(_, 0, 0).
mult(1, Y, Y).
mult(X, 1, X).

mult(X, Y, R) :- 
    Y > 1,             
    Y1 is Y - 1, 
    mult(X, Y1, R1), 
    R is R1 + X.





% Y > 1, <----- Das ist wichtig für die stacklimit exception. sie bricht die rekursion ab.
%Y1 = 1, dann Y1 = 0, dann Y1 = -1, dann Y1 = -2.........
% ab minus 1 wird es unendlich, weil es immer weiter abnimmt.