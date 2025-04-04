(mapcat (fn [x] (map #(+ x %) (range 3))) (range 3))
;Äusseres mapcat: Iteriert über x aus (range 3) → also x -> (0 1 2).
;Inneres map: Für jedes x, iteriert y -> (0 1 2), berechnet (+ x y).

(for [x (range 3)
      y (range 3)]
  (+ x y))



(map #(list % %) (filter #(== (mod % 3) 0) (range 10)))
;filter: Nur Elemente aus (range 10) mit mod % 3 == 0 → also 0 3 6 9.
;map: Für jedes dieser Elemente: (list % %) → also z. B. (0 0).

(for [x (range 10)
      :when (zero? (mod x 3))]
  (list x x))



(filter #(> (second %) (first %))
        (mapcat (fn [x] (map #(list x %) (range 4))) (range 4)))
;range 4 für x und innerhalb davon:
;map: bildet Paare (x y) für y (0 1 2 3) → alle Kombinationen.
;filter: Behalte nur Paare, bei denen y > x.

(for [x (range 4)
      y (range 4)
      :when (> y x)]
  (list x y))