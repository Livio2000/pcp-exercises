(ns lessons.pcp-lesson-06)

(defn state-change
  "based on current state, process the input and compute next state"
  [state input]
  (cond
    (= state 'cents00) (cond
                         (= input 10) 'cents10
                         (= input 20) 'cents20)
    (= state 'cents10) (cond
                         (= input 10) 'cents20
                         (= input 20) 'cents30)
    (= state 'cents20) (cond
                         (= input 10) 'cents30
                         (= input 20) 'cents20)))

(defn output [state input]
  (cond
    (= state 'cents00) "nothing"
    (= state 'cents10) (cond
                         (= input 10) "nothing"
                         (= input 20) "Kaugummi")
    (= state 'cents20) (cond
                         (= input 10) "Kaugummi"
                         (= input 20) "Münzauswurf")
    (= state 'cents30) "nothing"))

(defn gum-automat-simulation [state list-input]
  (cond
    (empty? list-input) "nichts eingeworfen"
    (empty? (rest list-input))
    (output state (first list-input))
    :else (gum-automat-simulation (state-change state (first list-input)) (rest list-input))))

(defn gum-automat []
  (let [state (atom 'cents00)]
    (print "input? ")
    (flush)
    (loop [input (read-line)
           new-state (state-change @state input)]
      (println "State: " @state ", input: " input " -> output: " (output @state input) ", new State: " new-state)
      (print "input? ")
      (flush)
      (reset! state new-state)
      (recur (read-line) (state-change @state input)))))