(ns hello.core-test
       (:require [clojure.test :refer [deftest is testing]]
                 [hello.core :as hc]))


     (deftest fact-test
       (is (= 120 (hc/fact 5)))
       (is not (= 740 (hc/fact 6)))
       (is (= 1 (hc/fact 0)))
       (is (= 1 (hc/fact 1))))

     (deftest last-element-test
       (is (= 4 (hc/lastEl [1 2 3 4])))
       (is not (= 5 (hc/lastEl [3 7 1 5 6])))
       (is (= nil (hc/lastEl []))))

     (deftest sum-of-array
       (is (= 10 (hc/sumOfArray [1 2 3 4])))
       (is (= 5 (hc/sumOfArray [-2 5 2])))
       (is (= -10 (hc/sumOfArray [-2 -1 -4 -3]))))

     (deftest distinct-element
      (is (= 4 (hc/distinct-elem [1 4 3 5 3 1 4 5 1])))
      (is not (= 4 hc/distinct-elem [0 2 3 5 1 2 6 3 4 2 7 1 0])))

     (deftest sum-of-squares
       (is (= 14 (hc/sum-of-sq [1 2 3])))
       (is (= 35 (hc/sum-of-sq [1 -5 3])))
       (is (= 0 (hc/sum-of-sq [0]))))

     (deftest perfect-number-test
       (is (= true (hc/perfect-number 6))))

     (deftest odd-number-test
       (is (= '(1 3 5) (hc/find-odd-1 [1 2 3 4 5 6]) ))
       (is (= '(3 5 7 9) (hc/find-odd-2 [2 3 4 5 6 7 8 9 0]))))

     (deftest reverse-seq-test
       (is (= [4 3 2 1] (hc/reverse-sequence [1 2 3 4])))
       (is (= '(7 5 2) (hc/reverse-sequence (sorted-set 5 7 2 7))))
       (is (= [[1 2][3 4][5 6]] (hc/reverse-sequence [[5 6][3 4][1 2]]))))

     (deftest fibo-seq-test
       (is (= '(1 1 2) (hc/fibo-seq 3)))
       (is (= '(1 1 2 3 5 8) (hc/fibo-seq 6)))
       (is (= '(1 1 2 3 5 8 13 21) (hc/fibo-seq 8))))
    
