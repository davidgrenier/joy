(if true :truthy :falsey)
(if [] :truthy :falsey)
(if nil :truthy :falsey)
(if false :truthy :falsey)

(def evil-false (Boolean. "false"))

(when (nil? false) "Actually nil, not false")

(seq [1 2 3])
(when (nil? (seq [])) [1])

(defn print-seq [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

(print-seq [1])

(seq nil)

(def guys-whole-name ["Guy" "Lewis" "Steele"])

(str (nth guys-whole-name 2) ", "
     (nth guys-whole-name 0) " "
     (nth guys-whole-name 1))

(defn printName [[a b c]]
  (str c ", " a " " b))

(printName guys-whole-name)

(def date-regex #"(\d{1,2})\/(\d{1,2})\/(\d{4})")

(let [rem (re-matcher date-regex "12/02/1975")]
  (when (.find rem)
    (let [[_ m d] rem]
      {:month m :day d})))

(let [[_ a b c d e f g h] "test"] a)

(let [[a b c & more :as all] (range 10)]
  (println "a b c are:" a b c)
  (println "more is:" more)
  (println "all is:" all))

(let [range-vec (vec (range 10))
      [a b c & more :as all] range-vec]
  (println "a b c are:" a b c)
  (println "more is:" more)
  (println "all is:" all))

(def guys-name-map
  {:f-name "Guy" :m-name "Lewis" :l-name "Steele"})

(let [{f-name :f-name m-name :m-name l-name :l-name} guys-name-map]
  (str l-name ", " f-name " " m-name))

(let [{:keys [f-name m-name l-name]} guys-name-map]
  (str l-name ", " f-name " " m-name))

(let [{f-name :f-name :as whole-name} guys-name-map]
  (println "First name is" f-name)
  (println "Whole name is below:")
  whole-name)

(let [{:keys [title f-name m-name l-name]
      :or {title "Mr."}} guys-name-map]
  (println title f-name m-name l-name))

(defn whole-name [& args]
  (let [{:keys [f-name m-name l-name]} args]
    (str l-name ", " f-name " " m-name)))

(let [{m-name :m-name} '(:f-name "Guy" :m-name "Lewis" :l-name "Steele")]
  (print m-name))

(let [[first-thing _ _ _ last-thing] [0 1 2 3 4]]
  (print first-thing last-thing))

(defn print-last-name [{:keys [l-name]}]
  (println l-name))

(print-last-name guys-name-map)

(range 5)

(defn f-values [f max-x max-y]
 (for [x (range max-x) y (range max-y) :when (and (> x 0) (> y 0))]
   [x y (rem (f x y) 256)]))

(def frame (java.awt.Frame.))
(def gfx (.getGraphics frame))

(.setVisible frame true)
(def sizx 256)
(.setSize frame (java.awt.Dimension. sizx sizx))

(.fillRect gfx 100 100 50 75)

(.setColor gfx (java.awt.Color. 255 128 0))
(.fillRect gfx 100 150 75 50)

(defn draw-f [f]
  (clear gfx)
  (doseq [[x y v] (f-values f sizx sizx)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))

(find-doc "exp")

(defn clear [g] (.clearRect g 0 0 sizx sizx))
(clear gfx)

(draw-f *)
