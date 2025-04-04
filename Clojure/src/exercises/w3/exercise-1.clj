(defn sum-numbers [nums]
  (map println nums) ; println wird nie ausgeführt
  (reduce + nums))


(sum-numbers [1 2 3 4 5])


; weil println in der map-Funktion ist, wird es nie ausgeführt. map ist eine lazy Funktion, die erst ausgeführt wird, wenn sie benötigt wird.

; 1. Möglichkeit "doall"
(defn sum-numbers2 [nums]
  (doall (map println nums)) ; wertet die LazySeq vollständig aus
  (reduce + nums))

;doall zwingt die Auswertung der LazySeq.

(sum-numbers2 [1 2 3 4 5])


; 2. Möglichkeit "dorun"
(defn sum-numbers3 [nums]
  (dorun (map println nums)) ; wertet die LazySeq vollständig aus
  (reduce + nums))

;dorun zwingt die Auswertung der LazySeq, gibt aber kein Ergebnis zurück.
(sum-numbers3 [1 2 3 4 5])