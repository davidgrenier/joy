(def ds (into-array [:willie :barnabas :adam]))
(seq ds)

(aset ds 1 :quentin)

(seq ds)

(def ds [:willie :barnabas :adam])

(def ds1 (replace {:barnabas :quentin} ds))
ds

ds1

(= [1 2 3] '(1 2 3))

(= [1 2 3] #{1 2 3})

(seq (seq ['a]))

(seq ['a 'b \c])

(rseq ['a 'b \c 'a])

(vals {:a \a})

(class (hash-map :a 1))
(class {:a 1})

(seq (hash-map :a 1))
(seq {:a 1})

(class (seq {:a 1}))
(class (seq (hash-map :a 1)))

(vec (range 10))

(let [my-vector [\a \b \c]]
  (into my-vector (range 10)))

(vector '3)

(into (vector-of :char) (range 0))

(into (vector-of :int) [Math/PI 2 1.3])

(into (vector-of :char) [100 101 102])

(into (vector-of :int) [1 2 623876371267813267326786327863])

(def a-to-j (vec (map char (range 65 75))))

(nth a-to-j 4)
(get a-to-j 4)
(a-to-j 4)

(nth [] 9)
(get [] 9)
(nth [] 9 nil)
(get nil 3)
(nth nil 3)

(seq a-to-j)
(rseq a-to-j)

(assoc a-to-j 9 "no longer E")

(replace {2 :a 4 \a} (vec (range 10)))

(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(get-in matrix [1 2])
(assoc-in matrix [1 2] \x)
(update-in matrix [1 2] * 10 10)

(defn neighbors
  ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]]
                        size
                        yx))
  ([deltas size yx]
   (filter (fn [new-yx]
             (every? #(< -1 % size) new-yx))
           (map #(vec (map + yx %))
                deltas))))

(neighbors 3 [1 1])

(->>
  (neighbors 3 [0 0])
  (map #(get-in matrix %)))

(def my-stack [1 2 3])
(peek my-stack)
(pop my-stack)

(conj my-stack 4)

(+ (peek my-stack) (peek (pop my-stack)))

(defn strict-map1 [f coll]
  (loop [coll coll acc nil]
    (if (empty? coll)
      (reverse acc)
      (recur (next coll)
             (cons (f (first coll)) acc)))))

(strict-map1 (partial + 1) (range 10))

(defn strict-map2 [f coll]
  (loop [coll coll acc []]
    (if (seq coll)
      (recur (rest coll) (conj acc (f (first coll))))
      acc)))

(strict-map2 - (range 10))
(source map)

(subvec a-to-j 3 6)

(first {:depth 15 :width 10 :height 20})

(doseq [[dimension amount] {:width 10 :height 20 :depth 15}]
  (println (str (name dimension) ":") amount "inches"))

(class (first {:depth 15}))

(val (first {:depth 15}))
(source key)

(cons 1 '(2 3))
(conj '(2 3) 1)

(class (cons 1 (range 10)))

(doc counted?)

(peek (seq '(1 2 3)))

(clojure.lang.PersistentQueue/EMPTY)
(defmethod print-method clojure.lang.PersistentQueue
  [q, w]

  (print-method '<- w)
  (print-method (seq q) w)
  (print-method '-< w))

(def schedule
  (conj clojure.lang.PersistentQueue/EMPTY
        :wake-up :shower :brush-teeth))

schedule

(pop schedule)

(#{:a 'b \c :d 'e \f} \c)
(#{:a :b :c :d} :e)
(get #{:a 1 :b 2} :b)

(get #{:a 1 :b 2} :z :nothing-doing)

(into #{[]} [()])

(into #{[1 2]} '[(1 2)])

(into #{[] #{} {}} [()])

(some #{:b :c} [:a 1 :b :c])

(some #{0 :b} [:a 1 :b 2])

(sorted-set :b :c :a)

(assoc (sorted-set [3 4] [1 2]) [3 1000])

(sorted-set :b 2 :c :a 3 1)

(def my-set (sorted-set :a :b))
(conj my-set "a")

(def my-set' (sorted-set-by #(= (name %) (name %2)) :a :b))
(conj my-set' "a")

(assoc {:a 3} :a 34 :b 39 :a :a)

(require 'clojure.set)

(clojure.set/intersection #{:humans :fruit-bats :zombies}
                          #{:chupacabra :zombies :humans})

(clojure.set/intersection #{:pez :gum :dots :skor}
                          #{:pez :skor :pocky}
                          #{:pocky :gum :skor})

(clojure.set/union #{:humans :fruit-bats :zombies}
                   #{:chupacabra :zombies :humans})

(clojure.set/union #{:pez :gum :dots :skor}
                   #{:pez :skor :pocky}
                   #{:pocky :gum :skor})

((hash-map :a 1 :b 2 :c 3 :d 4 :e 5) :f)
({:a 1 :b 2 :c 3 :d 4 :e 5} :f)

(let [m {:a 1 1 :b  [1 2 3] "4 5 6"}]
  [(m :a) (m [1 2 3])])

(seq {:a 1 :b 2})

(into {} [[:a 1] [:b 2]])

(into {} (map vec '((:a 1) (:b 2))))

(apply hash-map [:a 1 :b 2])
(class (array-map :a 1))
(class (sorted-map :a 1))
(class {:a 1})

(zipmap [:a :b] [1 2])

(sorted-map :thx 1138 :r2d 2)

(sorted-map "bac" 2 "abc" 9)
(sorted-map-by #(compare (subs %1 1) (subs %2 1)) "bac" 2 "abc" 9)

(sorted-map :a 1 "b" 2)

(assoc {1 :int} 1.0 :float)

(assoc (sorted-map 1 :int) 1.0 :float)

(seq (hash-map :a 1 :b 2 :c 3))
(seq (array-map :c 1 :a 2 :b 3))

(defn pos [e coll]
  "bad implementation"
  (let [cmp (if (map? coll)
              #(= (second %1) %2)
              =)]
    (loop [s coll idx 0]
      (when (seq s)
        (if (cmp (first s) e)
          (if (map? coll)
            (first (first s))
            idx)
          (recur (next s) (inc idx)))))))

(defn index [coll]
  (cond
    (map? coll) (seq coll)
    (set? coll) (map vector coll coll)
    :else (map vector (iterate inc 0) coll)))

(defn pos' [e coll]
  (for [[i v] (index coll) :when (= e v)] i))

(pos' 2 (assoc {0 2 1 2 23 3 2 2} 23 2))

(defn pos [pred coll]
  (for [[i v] (index coll) :when (pred v)] i))

(pos #{2 3} (assoc {0 2 1 2 23 3 2 2 9 3} 23 2))
