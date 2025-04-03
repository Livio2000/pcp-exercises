(+ (* 2 3) (/ 3 4))
(type (+ (* 2 3) (/ 3 4)))
;result: 27/4 , type: clojure.lang.Ratio
;rechnet (2*3) + (3/4)

(+ - * /)
;fehler (ClassCastException)
;es können keine operatoren als argumente der funktion + übergeben werden

'(+ - * /)
(type '(+ - * /))
;result: (+ - * /), type clojure.lang.PersistentList
;das ' macht dass die liste nich ausgewertet wird

(str 1.0 2 true)
(type (str 1.0 2 true))
;result: "1.02true", type: java.lang.String
;str macht aus allen argumenten strings

(+ (parse-long "123") (parse-double "0.45"))
(type (+ (parse-long "123") (parse-double "0.45")))
;result 123.45, type: java.lang.Double
;parse-long und parse-double machen aus strings zahlen

(or "this" "is" "crazy")
(type (or "this" "is" "crazy"))
;result: "this", type: java.lang.String
;or gibt das erste nicht-false argument zurück

(and "this" "is" "crazy")
;result: "crazy", type: java.lang.String
;and gibt das erste false argument zurück oder das letzte wenn alle true sind

(not "this" "is" "crazy")
;fehler (ArityException)
;not kann nur ein argument haben

((fn [x] (/ 1 x)) (/ 5 2))
(type ((fn [x] (/ 1 x)) (/ 5 2)))
;result: 2/5, type: clojure.lang.Ratio
;das fn macht eine funktion die 1 durch das argument teilt
;und das argument ist (/ 5 2) -> 5/2

(int? 3000000000)
(type (int? 3000000000))
;result: true, type: java.lang.Boolean
;int? prüft ob das argument ein int ist