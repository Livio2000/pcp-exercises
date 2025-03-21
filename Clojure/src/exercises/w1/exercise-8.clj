;a)
(defn sum-range [a b]
  (if (> a b)
    0                              ; Basisfall: Wenn a > b, gibt es nichts mehr zu summieren
    (+ a (sum-range (inc a) b))))  ; Rekursiver Aufruf mit (inc a)

(sum-range 1 5)
(sum-range 3 9)

;b)
(defn sum-squares [a b]
  (if (> a b)
    0                                      ; Basisfall: Ende der Rekursion
    (+ (* a a) (sum-squares (inc a) b))))  ; Rekursiver Aufruf mit Quadrat von a


(sum-squares 1 4)
(sum-squares 3 6)