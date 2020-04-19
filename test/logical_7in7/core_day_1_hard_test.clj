(ns logical-7in7.core-day-1-hard-test
  (:require [clojure.test :refer :all]
            [logical-7in7.core-day-1-hard :refer :all]))

(deftest test_hard_1
  (testing "hard_1"
    (let [expected '(:bia :pal :ben)
          actual (hard_1 :tom)]
    (is (= expected actual)))))

(deftest test_hard_1_a
  (testing "hard_1"
    (let [expected (set '(:ben :pal :bia))
          actual (set (hard_1 :tom))]
    (is (= expected actual)))))

(deftest test_ancestor_1
  (testing "hard_2"
    (let [expected (set '(:ana :tom :jay :pal :lui :jon))
          actual (set (hard_2 :ben))]
    (is (= expected actual)))))

(deftest test_siblingo
  (testing "hard_3"
    (let [expected (set '(:pre :lil :lal))
          actual (set (hard_3 :lal))]
    (is (= expected actual)))))

(deftest test_cousino_1
  (testing "hard_4_a"
    (let [expected (set '(:pre :xan :rik :lil :lal))
          actual (set (hard_4 :xan))]
    (is (= expected actual)))))


(deftest test_cousino
  (testing "hard_4"
    (let [expected (set (cons :yui (hard_4 :xan)))
          actual (set (hard_4 :yui))]
    (is (= expected actual)))))

