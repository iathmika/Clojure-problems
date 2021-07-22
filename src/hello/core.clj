
(require '[clojure.string :as str])
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
    0
    (reduce + seq)))

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
    nil
    (if (= seq (apply str (reverse seq)))
      true
      false)))

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


;; make sure to include docstring for every function


(defn fibo
  "This function takes three values: `n`, `x` and `y` and generates the `n`th fibonacci number . This is a helper function for `fibo-seq`."
  [n x y]
  (if (< n 2) x (fibo (- n 1) y (+ x y))))

(defn fibo-seq
  "This function generates the fibonacci sequence for the first n numbers."
  [n]
  (map #(fibo % 1 1) (range 1 (+ n 1))))

(defn count-occurence
  [seq n]
  (count (filter #{n} seq)))

;;Problem 55

(defn count-elements
  [seq]
  (zipmap (distinct seq) (map #(count-occurence seq %) (distinct seq))))



(def planets
  [{:pname "Mercury" :moons 0  :mass 0.0533}
   {:pname "Venus"   :moons 0  :mass 0.815}
   {:pname "Earth"   :moons 1  :mass 1}
   {:pname "Mars"    :moons 2  :mass 0.107}])



(defn less-mass-than-earth?
  [planet]
  (< (:mass planet) 1))

(defn less-than-one? 
  [number x] 
  (if (< x 1) 
    (conj number x) 
    number)
  )

(reduce less-than-one? [] [4 -5 -9 -1 3 ])
(defn reduce-filter
  [function init a]
  (reduce 
   (fn 
     [number x] 
     (if (function x)
       (conj number x)
       number))
   init
   a
   ))

(defn fizzbuzz
  [n]
  (cond (= 0 (mod n 15))
        "FIZZBUZZ"
        (= 0 (mod n 3))
        "FIZZ"
        (= 0 (mod n 5))
        "BUZZ"
        :else n))
(defn generate-fizzbuzz
  [n]
  (vec (map fizzbuzz (range 1 (inc n)))))

;; Problem 3: finding frequency of each word in a string
(defn split
  [string]
  (str/split string #" "))

(defn count-freq
  [string word]
  (count (filter #{word} (split string))))

(defn count-words
  [string]
  (zipmap (distinct (split string)) (map #(count-freq string %) (distinct (split string)))))

;;inteleave 2 sequences

(defn interleave-seq
  [seq1 seq2]
  (mapcat vector seq1 seq2))

;; [5 2 3 4] [1 1 1 1 1 1 1 1]
;; [5 1 2 1 3 1 1 1 1 1 1]
(defn interleave-seqs
  [seq1 seq2]
  (let [l (if (> (count seq1) (count seq2)) 1 2)]
    (loop [init1 0
           init2 0
           res []]
      (if (or (and (= l 1) (= (dec (count seq1))
                              init1))
              (and (= l 2) (= (dec (count seq2))
                              init2)))
        res
        (recur (inc init1)
               (inc init2) (cond (and (= l 1) (= (dec (count seq2)) init2))
                                 (conj res (nth seq1 init1))
                                 (and (= l 2) (= (dec (count seq1)) init1))
                                 (conj res (nth seq2 init2))
                                 :else (conj res (nth seq1 init1) (nth seq2 init2))))
        ))))

(defn interleave-seq2
  [seq1 seq2]
  (loop [res []
         list1 seq1
         list2 seq2]
    (if (and (empty? list1) (empty? list2))
      res
      (let [elem1 (first list1)
            elem2 (first list2)
            r (cond (= nil elem1) (conj res elem2)
                    (= nil elem2) (conj res elem1)
                    :else (conj res elem1 elem2))]
        (recur r (rest list1) (rest list2))))))



(defn word-frequency
  "Create a word frequency map out of a large string s.
  `s` is a long string containing a lot of words"
  [s]
  (reduce
    (fn [m w]
      (assoc m w (inc (m w 0))))
        {} (re-seq #"\w+" s)))


;; finding maximum of a list using loop recur
(defn max-using-loop
  "find the maximum value among the elements of a list using loop and recur functions"
  [list1]
  (loop [max -999 s list1]
    (if (empty? s) max 
        (if (> (first s) max)
          (recur (first s) (rest s))
          (recur max (rest s))))))

;;apply exlpodes a sequence so that it can be passed to a function that expects rest parameters

(defn max-of-a-list
  "find the maximum value among the elements of a list using apply function"
  [seq]
  (apply max seq)
  )

;; problem 28
(defn flatten1
  [s]
  (loop [res [] coll s]
    (if (empty? coll) res
        (if (sequential? (first coll))
          (recur (vec (concat res (flatten1 (first coll)))) (rest coll))
          (recur (conj res (first coll)) (rest coll))))))

(defn flatten2
  [s]
  (loop [res [] coll s]
    (if (empty? coll) res
        (if (sequential? (first coll))
          (recur (into res (flatten2 (first coll))) (rest coll))
          (recur (conj res (first coll)) (rest coll))))))

;;problem 99

(defn product-digits
  [n1 n2]
  (loop [prod (* n1 n2) res []]
    (if (pos? prod) (recur (quot prod 10) (cons (rem prod 10) res))
        res)))
