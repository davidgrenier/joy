(defn r->lfix
  ([a op b] (op a b))
  ([a op1 b op2 c] (op1 a (op2 b c)))
  ([a op1 b op2 c op3 d] (op1 a (op2 b (op3 c d)))))

(r->lfix 1 + 2)
(r->lfix 1 + 2 * 3)
(r->lfix 10 * 2 + 3)

(defn l->rfix
  ([a op b] (op a b))
  ([a op1 b op2 c] (op2 c (op1 a b)))
  ([a op1 b op2 c op3 d] (op3 d (op2 c (op1 a b)))))

(l->rfix 1 + 2 * 3)

(def order {+ 0 - 0 * 1 / 1})

(defn infix3 [a op1 b op2 c]
  (if (< (get order op1) (get order op2))
    (r->lfix a op1 b op2 c)
    (l->rfix a op1 b op2 c)))

(infix3 1 + 2 * 3)
(infix3 2 * 3 + 1)
(infix3 10 * 2 + 3)

(< (+ 1 (* 2 3))
   (* 2 (+ 1 3)))

(apply + (map #(+ % 1) (range 10)))

(apply > (reverse (range 10)))

(sort '(1 2 3 4))

(defprotocol Concatenable
  (cater [this other]))

(extend-type String
  Concatenable
  (cater [this other]
    (.concat this other)))

(cater "House" " of Leaves")

(extend-type java.util.List
  Concatenable
  (cater [this other]
    (concat this other)))

(cater [1 2 3] (range 10))

