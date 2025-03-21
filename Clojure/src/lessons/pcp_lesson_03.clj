(ns lessons.pcp-lesson-03)

;; PCP Phone Book

(defrecord Person [name number])

;; PCP Sum of list

(defn sum-list [a-list]
  (if (empty? a-list) 0 (+ (first a-list) (sum-list (rest a-list)))))

;; PCP double list

(defn redouble [a-list]
  (if (empty? a-list) () (cons (* 2 (first a-list)) (redouble (rest a-list)))))

;; PCP Insert in list

(defn sort-by-insert [num-list]
  (letfn [(insert [value a-list]
            (cond
              (empty? a-list) (list value)
              (<= value (first a-list)) (cons value a-list)
              :else (cons (first a-list) (insert value (rest a-list)))))]
    (if (empty? num-list) () (insert (first num-list) (sort-by-insert (rest num-list))))))