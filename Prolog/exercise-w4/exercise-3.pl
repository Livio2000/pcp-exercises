?- use_module(library(clpfd)).

%a
%{ T = 15, M = 3*T, M+X = 2*(T+X) }.


%b
donald_gerald_robert([D,O,N,A,L,D] + [G,E,R,A,L,D] = [R,O,B,E,R,T]) :-
    Vars = [D,O,N,A,L,G,E,R,B,T],                       % define the variables
    Vars ins 0..9,                                      % define the domain for the vars
    all_distinct(Vars),                                 % all variables must be different
    D*100000 + O*10000 + N*1000 + A*100 + L*10 + D +
    G*100000 + E*10000 + R*1000 + A*100 + L*10 + D #=   % attention: use #=/2
    R*100000 + O*10000 + B*1000 + E*100 + R*10 + T,     % addition must be ok
    D #\= 0, G #\= 0, R #\= 0,                          % numbers cannot start with zero
    label(Vars).                                        % assign values to the variables

%donald_gerald_robert(As + Bs = Cs).