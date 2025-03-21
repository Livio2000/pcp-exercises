(ns lessons.pcp-lesson-01)

;; PCP Hello World
(defn hello-world [username]
  (println (format "Hello, %s" username)))

;; PCP Greetings multiple arity declaration
(defn greeting
  "Returns a greeting of the form 'Hello, username.' Default username is 'world'."
  ([] (greeting "world"))
  ([username] (str "Hello, " username)))

;; PCP sum of squares as loop
(defn mean-of-squares-loop [n]
  (loop [result 0 x n]
    (if (zero? x) (/ result n)
                  (recur (+ result (* x x)) (dec x)))))

;; PCP sum of squares over sequence
(defn mean-of-squares-seq [n]
  (/ (reduce (fn [square x] (+ square (* x x))) (range (inc n))) n))

;; PCP sum of squares with recursion
(defn mean-of-squares-rec [n]
  (letfn [(squares [x] (if (zero? x) 0 (+ (* x x) (squares (dec x)))))]
    (/ (squares n) n)))

;; PCP sum of squares with recur
(defn mean-of-squares-recur [n]
  (letfn [(mean-of-squares [i, result]
    (if (= i 0)
      (/ result n)
      (recur (dec i) (+ result (* i i)))))]
  (mean-of-squares n 0)))

;; PCP Cinema Profits
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
