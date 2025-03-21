(ns lessons.pcp-lesson-04)

;; Maximum in a list: with recursion, with recursion and acccumulator, and with tail-recursion and accumulator

(defn list-max [a-list]
  (if (empty? (rest a-list))
    (first a-list)
    (if (> (first a-list) (list-max (rest a-list)))
      (first a-list)
      (list-max (rest a-list)))))

(defn list-max-accumulator [a-list]
  (letfn [(list-max-helper [a-list max]
            (cond
              (empty? a-list) max
              (> (first a-list) max)
              (list-max-helper (rest a-list) (first a-list))
              :else (list-max-helper (rest a-list) max)))]
    (list-max-helper (rest a-list) (first a-list))))

(defn list-max-accumulator-tail-recursion [a-list]
  (letfn [(list-max-helper [a-list max]
            (if (empty? a-list)
              max
              (recur (rest a-list) (if (> (first a-list) max) (first a-list) max))))]
    (list-max-helper (rest a-list) (first a-list))))

;; Greatest Common Denominator

(defn greatest-common-denominator [n m]
  (letfn [(first-divisor [g h i]
            (cond
              (= i 1) 1
              (and (= (rem g i) 0) (= (rem h i) 0)) i
              :else (first-divisor g h (- i 1))
              ))]
    (first-divisor m n (min m n))))

(defn greatest-common-denominator-euclid [n m]
  (if (zero? m)
    n
    (greatest-common-denominator-euclid m (rem n m))))

;; filter list with a threshold

(defn list-filter [rel-op a-list value]
  (if (empty? a-list)
    ()
    (if (rel-op (first a-list) value)
      (cons (first a-list)
            (list-filter rel-op (rest a-list) value))
      (list-filter rel-op (rest a-list) value))))

;; filter with predicate

(defn filter-prop [has-prop a-list]
  (if (empty? a-list)
    ()
    (if (has-prop (first a-list))
      (cons (first a-list) (filter-prop has-prop (rest a-list)))
      (filter-prop has-prop (rest a-list)))))

(defn square-number?
  "test of the integer value is the square of an integer value"
  [value]
  (== (int (Math/sqrt value)) (Math/sqrt value)))

(defn >5? [x] (> x 5))

(defn >5a? [x] (partial > 5))

;; average

(defn average [a-list]
  (if (empty? a-list)
    "no average"
    (/ (apply + a-list) (count a-list))))