(def a '(* 3 4))
(def b 'a)
(def c 'b)

(eval (eval (eval c)))

;Da c auf b verweist und b auf a, können wir eval mehrmals anwenden, um Schritt für Schritt zur Berechnung zu kommen
;c verweist auf b, also eval c ergibt b.
;b verweist auf a, also eval (eval c) ergibt a.
;a enthält (* 3 4), eine Liste, die noch nicht ausgewertet wurde.
;das letze eval wertet die Liste aus und gibt 12 zurück.