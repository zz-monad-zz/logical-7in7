(ns logical-7in7.core
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic])
  (:use [clojure.core.logic.pldb]))

(defn example []
  (run* [q]
    (== q true)))

(defn -main
  "Running example."
  [& args]
  (println "Start example")
  (example))
