(ns logical-7in7.core-test
  (:require [clojure.test :refer :all]
            [logical-7in7.core :refer :all]))

(deftest a-test
  (testing "This a simple example."
    (let [expected '(true)
          actual (example)]
    (is (= expected actual)))))
