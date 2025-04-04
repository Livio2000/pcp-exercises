(ns exercises.w3.exercise4.aufgabe4
  (:require [exercises.w3.exercise4.parser :refer [parse]])
  (:import [exercises.w3.exercise4.parser Op Val]))

; Beispiel: Baum für (2+3) * 4
(def expr1 (Op. "*" (Op. "+" (Val. 2) (Val. 3)) (Val. 4)))

; Beispiel: Baum für (2+3) * 4, aber mit parse
(def expr2 (parse "(2+3) * 4"))

(= expr1 expr2) ; sollte true ergeben

;a)
;2 * (4-2) + (6/3)
;        +
;       / \
;      *   /
;     / \ / \
;    2  - 6  3
;      / \
;     4   2

;b)
(def expr-1a (Op. "+" (Op. "*" (Val. 2) (Op. "-" (Val. 4) (Val. 2))) (Op. "/" (Val. 6) (Val. 3))))

;c)
(def expr-2a (parse "2 * (4-2) + (6/3)"))
(= expr-1a expr-2a)


;d)
(defn eval-expr [expr]
  (cond
    (instance? Val expr) (:value expr)
    (instance? Op expr)
    (let [left  (eval-expr (:left expr))
          right (eval-expr (:right expr))]
      (case (:op expr)
        "+" (+ left right)
        "-" (- left right)
        "*" (* left right)
        "/" (quot left right))) ; ganzzahlig
    ))
;Ein Val ist ein Zahlenwert – den geben wir einfach zurück.
;Ein Op enthält einen Operator (z. B. "+", "*"), einen linken und rechten Teilbaum.
;Wir werten rekursiv die linke und rechte Seite aus, dann wenden wir den Operator an.
(eval-expr expr-1a)


;e)
(defn compile-expr [expr]
  (cond
    (instance? Val expr)
    [(str "LOAD " (:value expr))]
    (instance? Op expr)
    (let [left-code  (compile-expr (:left expr))
          right-code (compile-expr (:right expr))
          op-code    (case (:op expr)
                       "+" ["ADD"]
                       "-" ["SUB"]
                       "*" ["MUL"]
                       "/" ["DIV"])]
      (concat left-code right-code op-code))))
;Wenn expr einfach nur eine Zahl ist (Val):
;Dann erzeugt sie einen Befehl wie "LOAD 5" – dieser lädt die Zahl auf den Stack.

;Wenn expr ein Rechenausdruck ist (Op):
;Dann: 
;ruft sie sich rekursiv auf, um die linke und rechte Seite ebenfalls in Befehle zu übersetzen.
;wählt den passenden Maschinenbefehl (ADD, SUB, …) je nach Operator.
;verbindet alles mit concat zu einem vollständigen Befehlprogramm.










;test
;GPT Code begin
(defn run-command [stack command]
  (let [[cmd & args] (clojure.string/split command #" ")]
    (case cmd
      "LOAD" (conj stack (Integer/parseInt (first args)))
      "ADD" (let [[right left & rest] (reverse stack)]
              (conj (vec (reverse rest)) (+ left right)))
      "SUB" (let [[right left & rest] (reverse stack)]
              (conj (vec (reverse rest)) (- left right))) ; links - rechts
      "MUL" (let [[right left & rest] (reverse stack)]
              (conj (vec (reverse rest)) (* left right)))
      "DIV" (let [[right left & rest] (reverse stack)]
              (conj (vec (reverse rest)) (quot left right))) ; links / rechts
      (throw (Exception. (str "Unbekannter Befehl: " cmd))))))
(defn run-program [commands]
  (let [final-stack (reduce run-command [] commands)]
    (peek final-stack)))
;End

(def expr (parse "2 * (4-2) + (6/3)"))

(eval-expr expr)
(compile-expr expr)

(= (eval-expr expr)
   (run-program (compile-expr expr)))

(= (eval-expr expr2)
   (run-program (compile-expr expr2)))

(= (eval-expr expr-2a)
   (run-program (compile-expr expr-2a)))
