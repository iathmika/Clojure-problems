
(ns hello.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn fact
  [n]
  (if (or (= n 1) (= n 0))
    1
    (* n (fact (dec n)))))
(defn lastEl
  [seq]
  (if (empty? seq)
    nil
    (nth seq (dec (count seq)))))

(defn sumOfArray
  [seq]
  (if (empty? seq)
    0)
  (reduce + seq))

(defn cycles
  [seq]
  (if (empty? seq)
    nil
    (take (* 2 (count seq)) (cycle seq) )))

(defn distinct-elem
  [seq]
  (if (empty? seq)
    nil
(count (into (set seq)))))


(defn palindrome
  [seq]
  (if (empty? seq)
    nil)
  (if (= seq (apply str (reverse seq)))
    true
    false))

(defn sum-of-sq
  [seq]
  (if (empty? seq)
    0
    (reduce + (map #(* % %) seq))))

(defn perfect-number
  [x]
  (= x (reduce + (filter #(zero? (mod x %)) (range 1 (inc (/ x 2)))))))

(defn find-odd-1
  [x]
  (filter #(odd? %) x))

(defn find-odd-2
  [x]
  (filter #(not (zero? (mod % 2))) x)) 

(defn reverse-sequence
  [seq]
  (reduce conj () seq))

(defn fibo
  [n x y] (if (< n 2) x
              (fibo (- n 1) y (+ x y))))
(defn fibo-seq
  [n]
  (map #(fibo % 1 1) (range 1 (+ n 1))))
