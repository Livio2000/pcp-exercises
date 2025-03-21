;Collatz-Problem https://de.wikipedia.org/wiki/Collatz-Problem
;Wenn n gerade ist → teile n durch 2:
;Wenn n ungerade ist → berechne 3n + 1:
;Das Verfahren wiederholt sich, bis n = 1 erreicht ist.

(defn collatz [n]
  (if (= n 1)
    [1]                                      ; Basisfall: Wenn n = 1, beenden wir die Rekursion
    (cons n (collatz (if (even? n)
                       (/ n 2)
                       (+ (* 3 n) 1))))))


(collatz 3)  ;; => [3 10 5 16 8 4 2 1]
(collatz 7)  ;; => [7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1]



;Von Wikipedia:
;Die Folge tritt somit in einen Zyklus ein, in dem die Zahlen 4, 2, 1 ständig wiederholt werden.
;Die Collatz-Vermutung lautet nun:
;Die Zahlenfolge mündet immer in den Zyklus 4, 2, 1, egal, mit welcher positiven natürlichen Zahl man beginnt.
;Diese Vermutung wurde bislang weder bewiesen noch widerlegt.