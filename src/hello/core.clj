
(ns hello.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn fact
  [n]
  (if (or (= n 1) (= n 0))
    1
    (* n (fact (dec n))))
  
  )
(defn lastEl
  [seq]
  (if (empty? seq)
    nil
    (nth seq (dec (count seq))))
  
  )

(defn sumOfArray
  [seq]
  (if (empty? seq)
    0)
  (reduce + seq)
  )

(defn cycles
  [seq]
  (if (empty? seq)
    nil

    (take (* 2 (count seq)) (cycle seq) ))
  )
(defn distinctElem
  [seq]
  (if (empty? seq)
    nil
(count (into (set seq)))
    ))


(defn palindrome
  [seq]
  (if (empty? seq)
    nil
    )
  (if (= seq (apply str (reverse seq)))
    true
    false)
  )

(defn sumOfSquares
  [seq]
  (if (empty? seq)
    nil
    ))
