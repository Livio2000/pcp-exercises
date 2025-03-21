;Darf man in den folgenden Beispielen die Bedingungsklauseln vertauschen, ohne dass sich die
;Semantik des Programms ändert?

;a)
(def temperatur 14)

(cond
  (> temperatur 35) "heiss"
  (> temperatur 25) "warm"
  (> temperatur 15) "mittel"
  :else "kalt")

;Nein, die Bedingungsklauseln dürfen nicht vertauscht werden, da die Bedingungen in der Reihenfolge
;von oben nach unten geprüft werden und die erste Bedingung, die zutrifft, ausgewertet wird.

;b)
(def zahl 6)

(cond
  (zero? (rem zahl 2)) "durch 2 teilbar"
  (zero? (rem zahl 3)) "durch 3 teilbar"
  :else "weder durch 2 noch durch 3 teilbar")

;Nein, z.b. wenn zahl = 6, dann wird "durch 2 teilbar" ausgegeben, obwohl zahl auch durch 3 teilbar ist.


;c)
(if (> temperatur 35) "heiss"
  (if (> temperatur 25) "warm"
    (if (> temperatur 15) "mittel"
      "kalt")))

;b)
;Könnte man die Beispiele aus a) und b) auch mit case implementieren? Begründen Sie.
;Nein da case nicht mit bedingungen arbeitet, sondern test auf wertegleichheit macht.
(def a 2)
(case a
  0 "zero"
  1 "one"
  2 "two"
  "other")