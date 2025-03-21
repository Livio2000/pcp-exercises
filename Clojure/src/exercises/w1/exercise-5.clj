(defn diskriminante [a b c] 
  (- (* b b) (* 4 a c)) 
  )

;a)
;Wenn die Diskriminante einer quadratischen Gleichung grösser oder gleich 0 ist, dann ist die Gleichung lösbar.
(defn loesbar? [a b c]
  (>= (diskriminante a b c) 0))

(loesbar? 1 2 1)
(loesbar? 1 0 1)


;b)
;D < 0 → 0 Lösungen
;D = 0 → 1 Lösung
;D > 0 → 2 Lösungen
(defn anzahl-loesungen [a b c]
  (cond
    (< (diskriminante a b c) 0)  0 
    (= (diskriminante a b c) 0)  1
    (> (diskriminante a b c) 0)  2
    ))

(anzahl-loesungen 1 2 1)   ; => 1 
(anzahl-loesungen 1 0 1)   ; => 0 
(anzahl-loesungen 1 -3 2)  ; => 2

;c)
(defn divisor [a]
  (* 2 a))

(defn loesungen [a b c]
  (cond
    (< (diskriminante a b c) 0)  []  
    (= (diskriminante a b c) 0)  [(/ (- b) (divisor a))]  
    (> (diskriminante a b c) 0)  [(/ (+ (- b) (Math/sqrt (diskriminante a b c))) (divisor a))     ; 1. Lösung
              (/ (- (- b) (Math/sqrt (diskriminante a b c))) (divisor a))])) ; 2. Lösung


(loesungen 1 2 1)   ; => [-1] 
(loesungen 1 0 1)   ; => []
(loesungen 1 -3 2)  ; => [2 1] 
