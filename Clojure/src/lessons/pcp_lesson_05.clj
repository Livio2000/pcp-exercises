(ns lessons.pcp-lesson-05)

(defn redouble [a-list]
  (letfn [(f [x] (* x 2))
          (g [a-numlist]
            (if (empty? a-numlist) ()
                                   (cons
                                     (f (first a-numlist))
                                     (g (rest a-numlist)))))]
    (g a-list)))

(defn x_y_z_y [x y z]
  (letfn [(square [n] (* n n))
          (plus-y-sqr [q] (square (+ q y)))]
    (+ (plus-y-sqr x) (plus-y-sqr z))))

(defn square [x] (Math/pow x 2))
(defn cube [x] (Math/pow x 3))
(defn sum [f i next n]
  (if (> i n) 0
              (+ (f i) (sum f (next i) next n))))

(defn sum [f i next n]
  (if (> i n) 0
              (+ (f i) (sum f (next i) next n))))

(defn polynom [a0 a1 a2]
  (fn [x] (+ a0 (* a1 x) (* a2 (Math/pow x 2)))))

; fast growing functions

(defn plus [x y]
  (if (= y 0) x (+ 1 (plus x (- y 1)))))
(defn times [x y]
  (if (= y 0) 0 (plus x (times x (- y 1)))))
(defn power [x y]
  (if (= y 0) 1 (times x (power x (- y 1)))))
(defn super [x y]
  (if (= y 0) 1 (power x (super x (- y 1)))))
(defn SUPER [x y]
  (if (= y 0) 1 (super x (SUPER x (- y 1)))))

(defn hyper [n]
  (cond
    (= n 1) plus
    (= n 2) times
    :else (fn [x y]
            (if (= y 0) 1
                        ((hyper (- n 1)) x ((hyper n) x (- y 1)))))))

(defn ackermann [n] ((hyper n) n n))