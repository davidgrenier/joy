(let [imadeuapi 3.14159265358979323846264338327950288419716939937M]
  (println (class imadeuapi))
  imadeuapi)

(let [butieatedit 3.14159265358979323846264338327950288419716939937]
  (println (class butieatedit))
  butieatedit)

(def clueless 9)

(class clueless)

(class (+ clueless 9000000000000000))

(class (+ clueless 90000000000000000000))

(class (+ clueless 9.0))

(+ Long/MAX_VALUE Long/MAX_VALUE)

(unchecked-add Long/MAX_VALUE Long/MAX_VALUE)

(float 0.0000000000000000000000000000000000000000000001)

1.0E-430

(let [approx-interval (/ 209715 2097152)
      actual-interval (/ 1 10)
      hours (* 3600 100 10)
      actual-total (double (* hours actual-interval))
      approx-total (double (* hours approx-interval))]
  (- actual-total approx-total))

(+ 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1)

(+ 1/10 1/10 1/10 1/10 1/10 1/10 1/10 1/10 1/10)

1.0e-430000000M

(def a 1.0e50)
(def b -1.0e50)
(def c 17.0)

(+ (+ a b) c)
(+ a (+ b c))

(+ a b c)
(+ b c a)

(def ra (rationalize a))
(def rb (rationalize b))
(def rc (rationalize c))

(+ (+ ra rb) rc)
(+ ra (+ rb rc))

(rational? (/ 1 3))

(numerator 12/9)
(denominator 12/9)

(= :a-keyword ::a-keyword)

::also-a-keyword

(def population {:zombies 2700 :humans 9})

(= (get population :zombies) (:zombies population))
(println (/ (get population :zombies)
            (:humans population))
         "zombies per capita")

(= (population :zombies) (get population :zombies) (:zombies population))

(defn pour [lb ub]
  (cond
    (= ub :toujours) (iterate inc lb)
    :else (range lb ub)))

(take 100 (pour 1 :toujours))
(pour 9 12)

(ns chap4)
(= ::test :chap4/test)

(defn do-blowfish [directive]
  (case directive
    :aquarium/blowfish (println "feed the fish")
    :crypto/blowfish (println "encode the message")
    :blowfish (println "not sure what to do")))

(ns crypto)
(user/do-blowfish :blowfish)
(user/do-blowfish ::blowfish)

(ns aquarium)
(user/do-blowfish :blowfish)
(user/do-blowfish ::blowfish)

(identical? 'goat 'goat)

('goat {'goat "test"})

(name :test)
(identical? :test :test)

(let [x 'goat y x]
  (identical? x y))

(let [x (with-meta 'goat {:ornery true})
      y (with-meta 'goat {:ornery false})]
  [(= x y)
   (identical? x y)
   (meta x)
   (meta y)])

(ns where-is)
(def a-symbol 'where-am-i)

a-symbol

(resolve 'a-symbol)

`a-symbol

(defn best [f xs]
  (reduce #(if (f % %2) % %2) xs))

(best > [1 3 4 2 7 5 3])

(.getMethods (class #"example"))

(let [[one two three] (re-seq #"\w+" "one-two/three")]
  (print one two three))

(let [[one] (re-seq #"\w+" "one-two-three")]
  (println one))

(re-seq #"\w(\w*)(\w)" "one-tow/three")

(re-find #"\w+" "one-two/three")
(doc re-find)
