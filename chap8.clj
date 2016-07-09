(-> 3 (/ 4) str keyword list)
(-> (/ 144 12) (* 4 (/ 2 3)) str keyword (list :33))

(eval 42)

(eval '(list 1 2))
(eval (list 1 2))

(eval (eval (list list list 1 2)))

(eval (list (symbol "+") 1 2))

(list (symbol "+") 1 2)
'((symbol "+") 1 2)

;(eval '((symbol "+") 1 2))

((symbol "+") 1 2)
(:+ 1 2)

(= (quote (symbol "+")) '(symbol "+"))

(def age 9)
(quote age)
'age

(quote (cons 1 [2 3]))
(cons 1 (2 3))
(cons 1 (quote (2 3)))
(cons 1 '(2 3))

(cons 1 ())

`(1 2 3)

(eval `(list 2 3))

`map
`Integer
`(map even? [1 2 3])

`is-always-right

`(list ~(+ 2 3) 4)

`(+ 10 (* 3 2))
`(+ 10 ~(* 3 2))

(let [x 2] `(1 ~x 3))
(let [x 2] '(1 ~x 3))

`(1 ~(2 3))

(let [x '(2 3)] `(1 ~x))
(let [x '(2 3)] (list 1 x))

(let [x `(~@(list 1 2 3))] x)

`potion#

(defn contextual-eval [ctx expr]
  (eval
    `(let [~@(mapcat (fn [[k v]] [k `'~v]) ctx)]
       ~expr)))

(let [x 9 y '(- x)]
  (println `y)
  (println ``y)
  (println ``~y)
  (println ``~~y)
  (println (contextual-eval {'x 36} y))
  (contextual-eval {'x 36} ``~~y))

(contextual-eval {'x 36} '(- x))

(defmacro do-until [& clauses]
  (when clauses
    (list 'clojure.core/when (first clauses)
          (if (next clauses)
            (second clauses)
            (throw (IllegalArgumentException. "do-until requires an even number of forms")))
          (cons 'do-until (nnext clauses)))))

(defmacro do-until2 [& clauses]
  (when clauses
    `(when ~(first clauses)
       ~(if (next clauses)
          (second clauses)
          (throw (IllegalArgumentException. "do-until requires an even number of forms")))
       ~(cons 'do-until (nnext clauses)))))

(do-until2
  (even? 2) (println "Even")
  (odd? 3) (println "Odd")
  (zero? 1) (println "You never see me")
  :lollipop (println "Truthy thing"))

(macroexpand-1 '(do-until true (prn 1) false (prn 2)))
(macroexpand-1 '(do-until2 true (prn 1) false (prn 2)))
