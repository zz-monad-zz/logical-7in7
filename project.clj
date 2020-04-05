(defproject logical-7in7 "0.1.0-SNAPSHOT"
  :description "miniKanren chapter from Seven More Languages in Seven Weeks"
  :url ""
  :license {:name "MIT"
            :url "queue://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.logic "0.8.5"]
                 [proto-repl "0.3.1"]
                 [proto-repl-charts "0.3.1"]]
  :profiles {:dev {:source-paths ["dev" "src" "test"]
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]]}})
