;a)
(def länge 5)
(def breite 4)

;fläche
(* länge breite)
;umfang
(* 2 (+ länge breite))
;diagonale
(Math/sqrt (+ (* länge länge) (* breite breite)))




;b)
(def höhe 3)

;volumen
(* länge breite höhe)
;oberfläche
(+ (* 2 (* länge breite)) (* 2 (* länge höhe)) (* 2 (* breite höhe)))


;c)
(defn fläche [länge breite]
  (* länge breite))

(fläche länge breite)

(defn umfang [länge breite]
  (* 2 (+ länge breite)))

(umfang länge breite)

(defn diagonale [länge breite]
  (Math/sqrt (+ (* länge länge) (* breite breite))))

(diagonale länge breite)

(defn volumen [länge breite höhe]
  (* länge breite höhe))

(volumen länge breite höhe)

(defn oberfläche [länge breite höhe]
  (+ (* 2 (* länge breite)) (* 2 (* länge höhe)) (* 2 (* breite höhe))))

(oberfläche länge breite höhe)