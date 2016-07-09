([:a :b] 0)

(map [:chton :phthor :beowulf :grendel] #{0 3})

(def fifth (comp first rest rest rest rest))
(fifth [1 2 3 4 5])

(defn fnth [n]
  (apply comp
   (cons first
     (take (dec n) (repeat rest)))))

(def fifth' (fnth 5))
(fifth' [1 2 3 4 5])

((fnth 5) (range 5))

(map (comp
       keyword
       #(.toLowerCase %)
       name)
     '(a B C))

((partial + 5) 100 200)
(apply + [])

(let [truthiness identity]
  [((complement truthiness) true)
   ((complement truthiness) 42)
   ((complement truthiness) false)
   ((complement truthiness) nil)])

(defn join
  {:test (fn []
           (assert
             (= (join "," [1 2 3]) "1,3,3")))}
  [sep s]
  (apply str (interpose sep s)))

(use '[clojure.test :as t])
(t/run-tests)
