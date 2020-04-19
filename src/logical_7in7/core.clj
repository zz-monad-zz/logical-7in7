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

(defn easy_1 []
  (run* [q] (membero q [1 2 3]) (membero q [3 4 5])))

(defn easy_2 []
  (run* [q] (appendo [1 2 3] q [1 2 3 4 5])))


(db-rel mano x)
(db-rel womano x)

(def facts
 (db
 [mano :alan-turing]
 [womano :grace-hopper]
 [mano :leslie-lamport]
 [mano :alonzo-church]
 [womano :ada-lovelace]
 [womano :barbara-liskov]
 [womano :frances-allen]
 [mano :john-mccarthy]))

(db-rel vitalo p s)
(db-rel turingo p y)

(def facts
 (-> facts
 (db-fact vitalo :alan-turing :dead)
 (db-fact vitalo :grace-hopper :dead)
 (db-fact vitalo :leslie-lamport :alive)
 (db-fact vitalo :alonzo-church :dead)
 (db-fact vitalo :ada-lovelace :dead)
 (db-fact vitalo :barbara-liskov :alive)
 (db-fact vitalo :frances-allen :alive)
 (db-fact vitalo :john-mccarthy :dead)
 (db-fact turingo :leslie-lamport :2013)
 (db-fact turingo :barbara-liskov :2008)
 (db-fact turingo :frances-allen :2006)
 (db-fact turingo :john-mccarthy :1971)))

(db-rel languageo p s)
(db-rel systemo p y)

(def facts
 (-> facts
 (db-fact languageo :alan-turing :haskell)
 (db-fact languageo :grace-hopper :python)
 (db-fact languageo :leslie-lamport :lisp)
 (db-fact languageo :alonzo-church :haskell)
 (db-fact languageo :ada-lovelace :java)
 (db-fact languageo :barbara-liskov :clojure)
 (db-fact languageo :frances-allen :java)
 (db-fact languageo :john-mccarthy :lisp)
 (db-fact systemo :leslie-lamport :functional)
 (db-fact systemo :barbara-liskov :object)
 (db-fact systemo :frances-allen :imperative)
 (db-fact systemo :john-mccarthy :functional)))


(defn easy_3 []
  (with-db facts
   (run* [q] 
         (womano q) 
         (languageo q :clojure) 
         (vitalo q :alive))))


(defn easy_4 []
  (with-db facts
   (run* [q] 
         (womano q) 
         (languageo q :clojure) 
         (vitalo q :alive))))


(defn scientisto [q]
 (conde
   [(womano q)]
   [(mano q)]))


(defn medium_1 []
  (with-db facts
   (run* [q] (scientisto q ))))


(defn medium_2 []
  (with-db facts
   (run* [q] 
     (fresh [y]
       (scientisto q) 
       (turingo q y)))))

