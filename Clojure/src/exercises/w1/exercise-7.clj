;a)
(defn chf-to-eur [chf]
  (* chf 0.95))  ;Beispielkurs 1 CHF = 0.95 EUR


(chf-to-eur 100)
(chf-to-eur 50)


;b)
;Umrechnung Celsius in Fahrenheit: °F = °C x 1,8 + 32.
(defn celsius-fahrenheit [c]
  (+ (* (/ 9 5) c) 32))

(type (celsius-fahrenheit 0))

(celsius-fahrenheit 0)
(celsius-fahrenheit 100)
(celsius-fahrenheit 30) 


;c)
;Ergebnis=((Quelle-Max − Quelle-Min)/(Ziel-Max − Ziel-Min))∗(Wert − Quelle-Min) + Ziel-Min
(defn scale [src-min src-max dst-min dst-max value]
  (+ (* (/ (- dst-max dst-min) (- src-max src-min))
        (- value src-min))
     dst-min))

(scale 0 100 32 212 30)  ; => 86.0 (30°C → 86°F)
(scale 0 100 32 212 0)   ; => 32.0 (0°C → 32°F)
(scale 0 100 32 212 100) ; => 212.0 (100°C → 212°F)