(def my-phone-dir
  (atom
   (list (hash-map :name 'Adam :phone 4711)
         (hash-map :name 'Eva :phone 4712))))


;a)
;In der funktionalen Programmierung arbeiten wir ohne Nebenwirkungen und bevorzugen unveränderliche Daten. 
;Der Einsatz von atom und das nachträgliche Verändern des Verzeichnisses (z. B. durch add-entry) 
;widerspricht dem funktionalen Ansatz, weil:
; - Daten mutiert werden (via swap! oder reset!)
; - Das Verhalten hängt vom Zustand ab (nicht rein funktional)
; - Es entstehen Seiteneffekte, was Debugging und Testbarkeit erschwert

; -> Das Prinzip der Unveränderlichkeit (Immutability) wird verletzt!


;b)
(defn look-at [dir name]
  (let [entries @dir]
    (:phone (first (filter #(= (:name %) name) entries)))))
;@dir entpackt das Atom, also (list {:name "Adam" :phone 4711} ...)
;filter sucht alle Einträge, deren :name dem gesuchten Namen entspricht
;first holt den ersten passenden Eintrag (oder nil)
;:phone extrahiert die Nummer (oder gibt nil, wenn keiner gefunden wurde)

(look-at my-phone-dir 'Adam)
(look-at my-phone-dir 'Eva) 


;c)
(defn add-entry [dir name phone]
  (swap! dir conj {:name name :phone phone}))
;swap! verändert das Atom mit der Funktion conj, die einen neuen Eintrag ans Ende der Liste hängt
;Es wird ein neuer hash-map mit :name und :phone hinzugefügt


(look-at my-phone-dir 'Alex)
(add-entry my-phone-dir 'Alex 4713)
(look-at my-phone-dir 'Alex) 