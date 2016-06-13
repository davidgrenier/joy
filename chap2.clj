[-127 -0x7f -0177 -32r3v -2r01111111]

[1.17 +1.22 -2. 366e7 32e-14 10.7e-3]

[22/7 -7/22 1028798300297636767687498928872/88299897008789478784 -103/4]

(def yucky-pi 22/7)
(quote yucky-pi)

(quote (:chumby :2 :? :ThisIsTheNameOfAKeyword))

["This is a string" "This is also a 
                    String"]

[\a \A \u0042 \\ \u30DE \u2192 \→]

({1 2 :a :b :c :d} :b)
(#{1 2 :a :b :c :d :when false} :when)

(vector 1 2 3)

(def x 42)
(def y)
[y \→]

((fn [x y]
   (print "Making a set")
   #{x y}) 2 3)

(def make-set
  (fn [x y]
    (println "Making a set")
    #{x y}))

(make-set 1 2)

(defn make-set' [x y] #{x y})

(make-set' 1 2)

(defn make-set''
  ([x] #{x})
  ([x y] #{x y}))

(make-set'' 2 3 4)

(defn arity2+ [first second & more]
  (vector first second more))

(arity2+ 1 2 3 4)
(arity2+ 1 2)

(def make-list0 #(list))
(make-list0)

(def make-list2 #(list %1 %2))
(make-list2 1 2)

(def make-list2+ #(list %1 %2 %&))
(apply make-list2+ (range 10))

(def make-list2' #(cons %1 (cons %2 (apply list %&))))
(make-list2' 1 2 3 4 5)

(do
    (def x 5)
  (def y 4)
  (+ x y)
  [x y])

(let [r 5
      pi 3.1415
      r-squared (* r r)]
  (println "radius is" r)
  (* pi r-squared))

(defn print-down-from [x]
  (println "test")
  (when (pos? x)
    (println x)
    (recur (dec x))))

(defn sum-down-from [sum x]
  (if (pos? x)
    (recur (+ sum x) (dec x))
    sum))

(sum-down-from 0 10)

(defn sum [x]
  (loop [sum 0 x x]
    (if (pos? x)
      (recur (+ sum x) (dec x))
      sum)))

(sum 4)

(defn facto [x]
  (loop [prod 1 x x]
    (if (pos? x)
      (recur (* prod x) (dec x))
      prod)))

(facto 5)

(sort [1 2 3])
(first [1 2])

(def age 9)
(quote age)

(do
    (def wrong 9)
  (quote wrong))

(eval '(cons [3 2] '(2 3 4)))
'(1 ~(+ 1 2))

(let [x 2]
  `(1 ~x 3))

(first `(1 ~'(2 3)))

(let [x '(2 3)] `(1 ~@x))

`potion#

(vec '(1 2 3))

java.util.Locale/JAPAN

(java.lang.Math/sqrt 9)

(new java.awt.Point 0 1)

(new java.util.HashMap {"foo" 42 "bar" 9 "baz" "quux"})

(java.util.HashMap. {:foo 42 :bar 9 :baz "quux"})

(.-x (java.awt.Point. 10 20))

(.divide (java.math.BigDecimal. "42") 2M)
(.divide 2M 2M)

(let [origin (java.awt.Point. 0 0)]
  (set! (.-x origin) 15)
  (str origin))

(.endsWith (.toString (java.util.Date.)) "2016")

(.. (java.util.Date.) toString (endsWith "2016"))

(doto (java.util.HashMap.)
  (.put "HOME" "/home/me")
  (.put "SRC" "src")
  (.put "BIN" "classes"))

(throw (Exception. "I done throwed"))

(defn throw-catch [f]
  [(try
        (f)
     (catch ArithmeticException e "No dividing by zero!")
     (catch Exception e (str "You are so bad " (.getMessage e)))
     (finally (println "returning... ")))])

(throw-catch (fn [] (throw (Exception. "Cry baby"))))

(try
     (throw (Error. "Idone throwed in CLJS"))
  (catch js/Error err "I done catched in CLJS"))

(def x)

(defn hello []
  (println "Hello Cleveland!"))

(ns test)

(pr *ns*)

(ns joy.chess)

(defn report-ns []
  (str "The current namespace is " *ns*))

(joy.chess/report-ns)

(ns toto
  (:require [joy.chess :as s]))

(s/report-ns)

(ns joy.use-ex
  (:require [clojure.string :rename {capitalize c}]))

(map c ["kilgore" "trout"])
