(ns lessons.w3)

(defn add [a b c] (+ a b c))

((partial add 1) 2 3) 