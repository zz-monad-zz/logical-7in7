(ns logical-7in7.core-test
  (:require [clojure.test :refer :all]
            [logical-7in7.core :refer :all]))


(deftest a-test
  (testing "This a simple example."
    (let [expected '(true)
          actual (example)]
    (is (= expected actual)))))


(deftest test_easy_1
  (testing "easy_1"
    (let [expected '(3)
          actual (easy_1)]
    (is (= expected actual)))))


(deftest test_easy_2
  (testing "easy_2"
    (let [expected '((4 5))
          actual (easy_2)]
    (is (= expected actual)))))

(deftest test_easy_3
  (testing "easy_3"
    (let [expected '(:barbara-liskov)
          actual (easy_3)]
    (is (= expected actual)))))
