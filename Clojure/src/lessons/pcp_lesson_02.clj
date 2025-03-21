(ns lessons.pcp-lesson-02)

;; define grades
(defn grade [score]
  (cond
    (not (number? score)) "Zahl eingeben!"
    (not (integer? score)) "Ganze Zahl 0 <= x <= 15 eingeben!"
    (<= 13 score 15) "ausgezeichnet"
    (<= 10 score 12) "sehr gut"
    (<= 7 score 9) "gut"
    (<= 4 score 6) "ausreichend"
    (<= 1 score 3) "nicht erfüllt: Nachbesserung"
    (= 0 score) "nicht erfüllt"
    :else "Ganze Zahl 0 <= x <= 15 eingeben!"))

;; define point record
(defrecord Point [x y])

(defn point-scaling [p scale]
  (assoc p :x (* (:x p) scale)
           :y (* (:y p) scale)))

;; define function with function as parameter
(defn do-it [fkt arg]
  (fkt arg))

;; define triangle
(defrecord Triangle [A B C])

(defn mp-a [this]
  (->Point
    (/ (+ (-> this :B :x) (-> this :C :x)) 2)
    (/ (+ (-> this :B :y) (-> this :C :y)) 2)))
