(ns lessons.w1)

; 1 + 1 + (2 * 2)
(+ 1 1 (* 2 2))

(quote (1 2 3))

(even? 2)

(+ 0.1 0.2)

(- -5)

(/ 1 2)

(= 1 2)

(and 1 42 17.0 true "hello")
(and "test" nil 0)
(or 3 2 1 false)


(def x 42)
(def y 17)
(+ x y)


(defn square [x] (* x x))
(square 3)


; übung profit eines Kinos
(defn attendees [price]
  (+ 120 (* 15 (/ (- 8.00 price) 0.50))))

(defn revenue [price]
  (* (attendees price) price))

(defn cost [price]
  (+ 250 (* 0.75 (attendees price))))

(defn profit [price]
  (- (revenue price) (cost price)))

(profit 6.50)

(do (print "Hello, ") (print "World!") (+ 2 2))

(def i 3)
(when (< i 5) ; ist i kleiner 5?
  (println "i") ; gibt "i" aus
  (println "ist kleiner 5") ; gibt "ist kleiner 5" aus
  i) 