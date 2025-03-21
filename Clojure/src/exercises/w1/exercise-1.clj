(/ 1 (+ 1 1))
; 1 / (1 + 1) = 1/2


(/ 1 (+ 1 (/ 1 (+ 1 1))))
; 1 / (1 + (1 / (1 + 1))) =
; 1 / (1 + (1 / 2)) =
; 1 / (1 + 1/2) =
; 1 / 3/2 =
; 2/3


(/ 1 (+ 1 (/ 1 (+ 1 (/ 1 (+ 1 1))))))
; 1 / 1 + (1 / (1 + (1 / (1 + 1)))) =
; 1 / 1 + (1 / (1 + (1 / 2))) =
; 1 / 1 + (1 / (1 + 1/2)) =
; 1 / 1 + (1 / 3/2) =
; 1 / 1 + 2/3 =
; 1 / 5/3 =
; 3/5