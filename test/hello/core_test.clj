(ns hello.core-test
  (:require [clojure.test :as ct]
            [hello.core :as hc]))


(ct/deftest fact1
  (testing "Positive testing"
    (is (= 120 (hc/fact 5))))
  (testing "Negative testing"
    (is not (= 740 (hc/fact 6))))
  (testing "Positive testing"
    (is (= 1 (hc/fact 0))))
  (testing "Positive testing"
    (is (= 1 (hc/fact 1))))
  )

(ct/deftest lastEltest

  (testing "positive testing"
    (is (= 4 (hc/lastEl [1 2 3 4]))))
  (testing "negative testing"
    (is not (= 5 (hc/lastEl [3 7 1 5 6])))
    )
    (testing "Positive testing"
      (is (= nil (hc/lastEl []))))
  )
(ct/deftest sumOA
  (testing "test11"
    (is (= 10 (hc/sumOfArray [1 2 3 4]))))
  (testing "test2"
    (is (= 5 (hc/sumOfArray [-2 5 2]))))
   (testing "test3"
    (is (= -10 (hc/sumOfArray [-2 -1 -4 -3]))))
  )


