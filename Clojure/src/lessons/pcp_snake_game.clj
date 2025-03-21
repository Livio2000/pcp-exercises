(ns lessons.pcp-snake-game
  (:use [pcp-clojure.import-static])
  (:import (java.awt Color Dimension)
           (java.awt.event ActionListener KeyListener)
           (javax.swing JFrame JOptionPane JPanel Timer)))
(import-static java.awt.event.KeyEvent VK_LEFT VK_RIGHT VK_UP VK_DOWN)


;;region Global Declaration

; width and height set the size of the game board, and point-size is used to convert a game point into screen pixels.
; turn-millis is the heartbeat of the game, controlling how many milliseconds pass before each update of the game board.
; win-length is how many segments your snake needs before you win the game.
; (Five is a small number suitable for testing.) The dirs maps symbolic constants for the four directions to their vector equivalents.
; Since Swing already defines the VK_ constants for different directions, we’ll reuse them here rather than define our own.
(def width 75)
(def height 50)
(def point-size 10)
(def turn-millis 75)
(def win-length 5)
(def dirs {VK_LEFT  [-1 0]
           VK_RIGHT [1 0]
           VK_UP    [0 -1]
           VK_DOWN  [0 1]})

;;endregion

;;region Model Functions

; The add-points function adds points together. You can use add-points to calculate the new position of a moving game object.
(defn add-points [& pts]
  (vec (apply map + pts)))

;
(defn point-to-screen-rect [pt]
  (map #(* point-size %)
       [(pt 0) (pt 1) 1 1]))

; create an apple on the game board
(defn create-apple []
  {:location [(rand-int width) (rand-int height)]
   :color    (Color. 210 50 90)
   :type     :apple})

; Because a snake can occupy multiple points on the board, it has a :body, which is a list of points.
; Also, snakes are always in motion in some direction expressed by :dir.
(defn create-snake []
  {:body  (list [1 1])
   :dir   [1 0]
   :type  :snake
   :color (Color. 15 160 70)})

; move uses a fairly complex binding expression.
; The {:keys [body dir]} part makes the snake’s body and dir available as their own bindings,
; and the :as snake part binds snake to the entire snake.
; The function proceeds as follows:
;     add-points creates a new point, which is the head of the original snake offset by the snake’s direction of motion.
;     cons adds the new point to the front of the snake. If the snake is growing, the entire original snake is kept.
;               Otherwise, it keeps all the original snake except the last segment (butlast).
;     assoc returns a new snake, which is a copy of the old snake but with an updated :body.
(defn move [{:keys [body dir] :as snake} & grow]
  (assoc snake :body (cons (add-points (first body) dir)
                           (if grow body (butlast body)))))

(defn turn [snake newdir]
  (assoc snake :dir newdir))

(defn win? [{body :body}]
  (>= (count body) win-length))

(defn head-overlaps-body? [{[head & body] :body}]
  (contains? (set body) head))

(def lose? head-overlaps-body?)

(defn eats? [{[snake-head] :body} {apple :location}]
  (= snake-head apple))

(defn update-positions [snake apple]
  (dosync
    (if (eats? @snake @apple)
      (do (ref-set apple (create-apple))
          (alter snake move :grow))
      (alter snake move)))
  nil)

(defn update-direction [snake newdir]
  (when newdir (dosync (alter snake turn newdir))))

(defn reset-game [snake apple]
  (dosync (ref-set apple (create-apple))
          (ref-set snake (create-snake)))
  nil)
;;endregion

;;region GUI functions

(defn fill-point [g pt color]
  (let [[x y width height] (point-to-screen-rect pt)]
    (.setColor g color)
    (.fillRect g x y width height)))

(defmulti paint (fn [g object & _] (:type object)))

(defmethod paint :apple [g {:keys [location color]}]        ; <label id="code.paint.apple"/>
  (fill-point g location color))

(defmethod paint :snake [g {:keys [body color]}]            ; <label id="code.paint.snake"/>
  (doseq [point body]
    (fill-point g point color)))
;;endregion

;;region Game

; Swing calls paintComponent (line 3) to draw the panel. paintComponent calls proxy-super to invoke the normal JPanel behavior,
; and then it paints the snake and the apple.
;
; Swing will call actionPerformed (line 7) on every timer tick. actionPerformed updates the positions of the snake and the apple.
; If the game is over, the program displays a dialog and resets the game. Finally, it triggers a repaint with (.repaint this).
;
; Swing calls keyPressed (line 16) in response to keyboard input. keyPressed calls update-direction to change the snake’s direction.
; (If the keyboard input is not an arrow key, the dirs function returns nil and update-direction does nothing.) The game panel
; ignores keyReleased and keyTyped.
(defn game-panel [frame snake apple]
  (proxy [JPanel ActionListener KeyListener] []
    (paintComponent [g]                                     ; <label id="code.game-panel.paintComponent"/>
      (proxy-super paintComponent g)
      (paint g @snake)
      (paint g @apple))
    (actionPerformed [e]                                    ; <label id="code.game-panel.actionPerformed"/>
      (update-positions snake apple)
      (when (lose? @snake)
        (reset-game snake apple)
        (JOptionPane/showMessageDialog frame "You lose!"))
      (when (win? @snake)
        (reset-game snake apple)
        (JOptionPane/showMessageDialog frame "You win!"))
      (.repaint this))
    (keyPressed [e]                                         ; <label id="code.game-panel.keyPressed"/>
      (update-direction snake (dirs (.getKeyCode e))))
    (getPreferredSize []
      (Dimension. (* (inc width) point-size)
                  (* (inc height) point-size)))
    (keyReleased [e])
    (keyTyped [e])))

(defn game []
  (let [snake (ref (create-snake))
        apple (ref (create-apple))
        frame (JFrame. "Snake")
        panel (game-panel frame snake apple)
        timer (Timer. turn-millis panel)]
    (doto panel
      (.setFocusable true)
      (.addKeyListener panel))
    (doto frame
      (.add panel)
      (.pack)
      (.setVisible true))
    (.start timer)
    [snake, apple, timer]))
;;endregion

(game)