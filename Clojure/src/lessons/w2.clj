(ns lessons.w2)
(cons 3 (cons 2 (cons 1 ())))

(def a '(1 2 3 4))
(def b (cons 5 (rest a)))

b



(loop [n 1]
  (if (> n 256)
    0
    (do (print n " ") (recur (* n 2)))))


(defn find-sums [nums target path]
  (cond
    (= target 0) (println path) ; Lösung gefunden - Liste ausgeben
    (empty? nums) nil ; Sackgasse - nichts zurückgeben
    :else
    (do
 ; Fall 1: Wir nehmen das erste Element
      (find-sums (rest nums)
                 (- target (first nums))
                 (cons (first nums) path))

 ; Fall 2: Wir nehmen das erste Element nicht
      (find-sums (rest nums)
                 target
                 path))))

(find-sums '(1 2 3 4 5) 6 ())


(defn apply-twice [f x]
  (f (f x)))

(apply-twice inc 1)


(defn make-adder [n]
  (fn [x] (+ x n)))
(def add-3 (make-adder 3))
(def add-10 (make-adder 10))
(add-3 5)
(add-10 5) 