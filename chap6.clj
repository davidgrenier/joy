(def baselist (list :barnabas :adam))
(def lst1 (conj baselist :willie))
(def lst2 (cons :phoenix baselist))

lst1

lst2

(= (next lst1) (next lst2))

(identical? (next lst1) (next lst2))

{:val 5 :L nil :R nil}

(defn xconj [t v]
  (cond
    (nil? t) {:val v :L nil :R nil}
    (< v (:val t)) (assoc t :L (xconj (:L t) v))
    :else (assoc t :R (xconj (:R t) v))))

(defn xseq [t]
  (when t
    (concat (xseq (:L t)) [(:val t)] (xseq (:R t)))))

(-> (xconj nil 5)
     (xconj 3)
     (xconj 7)
    (xconj 9)
    (xconj 1)
    (#(identical? (:L %) (:L (xconj % 99)))))

(defn if-chain [x y z]
  (if x
    (if y
      (if z
        (do (println "Made it!")
            :all-truthy)))))

(if-chain () 42 true)

(defn and-chain [x y z]
  (and x y z (do (println "Made it!") :all-truthy)))

(and-chain () 42 'yes)

(defn rec-step [[x & xs]]
  (if x
    [x (rec-step xs)]
    []))

(def very-lazy (-> (iterate #(do (print \.) (inc %)) 1)
                   rest rest rest))

(def less-lazy (-> (iterate #(do (print \.) (inc %)) 1)
                   next next next))

(println (first very-lazy))
(println (first less-lazy))

(defn lz-rec-step [s]
  (lazy-seq
            (if (seq s)
              [(first s) (lz-rec-step (rest s))]
              [])))

(dorun (lz-rec-step (range 60000)))

(defn simple-range [i limit]
  (lazy-seq
    (when (< i limit)
      (cons i (simple-range (inc i) limit)))))

(simple-range 0 9)

(let [r (range 1e9)]
  (first r)
  (last r))

(let [r (range 1e9)]
  (last r)
  (first r))

(take 100 (iterate #(/ % 2) 1))

(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(triangle 4)

(map triangle (range 1 11))

(def tri-nums (map triangle (iterate inc 1)))

(take 10 (filter even? tri-nums))

(nth tri-nums 99)

(double (reduce + (take 1000 (map / tri-nums))))

(take 2 (drop-while #(< % 10000) tri-nums))

(print (delay + 1 2))

(defn defer-expensive [cheap expensive]
  (if-let [good-enough (force cheap)]
    good-enough
    (force expensive)))

(defer-expensive
  (delay :cheap)
  (delay (do (Thread/sleep 5000) :expensive)))

(defer-expensive
  :cheap
  (delay (do (Thread/sleep 5000) :expensive)))

(defn defer-exp [cheap expensive]
  (if-let [good-enough (cheap)]
    good-enough
    (expensive)))

(defer-exp
  (fn [] :cheap)
  (fn [] (do (Thread/sleep 3000) :expensive)))

(defer-exp
  (fn [] false)
  (fn [] (do (Thread/sleep 3000) :expensive)))

(let [x (delay false)
      _ (force x)]
  (delay? x))

(defn inf-triangles [n]
  {:head (triangle n)
   :tail (delay (do (println "Calculating for" (inc n)) (inf-triangles (inc n))))})

(def head :head)
(def tail (comp force :tail))

(def alltrig (inf-triangles 1))
(-> alltrig tail tail tail head)
(-> alltrig tail tail tail tail tail tail tail tail tail tail tail head)

(defn taker [n l]
  (loop [t n src l ret []]
    (if (zero? t)
      ret
      (recur (dec t) (tail src) (conj ret (head src))))))

(taker 10 alltrig)

(defn nthr [l n]
  (if (zero? n)
    (head l)
    (recur (tail l) (dec n))))

(nthr alltrig 99)
