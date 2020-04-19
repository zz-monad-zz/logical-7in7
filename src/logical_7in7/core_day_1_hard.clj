(ns logical-7in7.core-day-1-hard
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic])
  (:use [clojure.core.logic.pldb]))

(db-rel mano x)
(db-rel womano x)

(def facts
 (db
 [mano :rog]
 [mano :anu]
 [mano :vic]
 [mano :lil]
 [mano :pre]
 [mano :min]
 [mano :kim]
 [mano :rui]
 [mano :rik]
 [womano :lin]
 [womano :tre]
 [womano :sof]
 [womano :xan]
 [womano :lal]
 [womano :yui]
 [womano :ver]
 [womano :bar]
 [womano :win]
 [mano :tom]
 [mano :bob]
 [mano :raj]
 [mano :jon]
 [mano :pal]
 [mano :ben]
 [mano :jay]
 [womano :sue]
 [womano :ana]
 [womano :len]
 [womano :mar]
 [womano :lui]
 [womano :bia]))

(db-rel childo f m c)
(db-rel spouseo m w)

(def facts
 (-> facts
 (db-fact spouseo :rog :lin)
 (db-fact spouseo :anu :sof)
 (db-fact spouseo :tre :vic)
 (db-fact spouseo :xan :lal)
 (db-fact spouseo :kim :ver)
 (db-fact spouseo :rui :bar)
 (db-fact spouseo :xan :win)

 (db-fact childo :rog :lin :anu)
 (db-fact childo :rog :lin :tre)
 (db-fact childo :anu :sof :lil)
 (db-fact childo :anu :sof :pre)
 (db-fact childo :anu :sof :lal)
 (db-fact childo :tre :vic :xan)
 (db-fact childo :xan :win :yui)
 (db-fact childo :kim :ver :vic)
 (db-fact childo :kim :ver :bar)
 (db-fact childo :rui :bar :rik)

 (db-fact spouseo :tom :sue)
 (db-fact spouseo :bob :ana)
 (db-fact spouseo :jay :lui)
 (db-fact childo :jay :lui :jon)
 (db-fact childo :tom :sue :bia)
 (db-fact childo :tom :ana :pal)
 (db-fact childo :jon :len :mar)
 (db-fact childo :pal :jon :ben)
 (db-fact childo :bob :ana :raj)))

(defn descendanto [e p]
 (conde
   [(fresh [f m]
     (childo f m e)
     (== f p))]
   [(fresh [f m]
     (childo f m e)
     (== m p))]
   [(fresh [f m]
     (childo f m e)
     (descendanto f p))]
   [(fresh [f m]
     (childo f m e)
     (descendanto m p))]))

(defn ancestoro [e p]
 (conde
   [(fresh [f m]
     (childo f m e)
     (== f p))]
   [(fresh [f m]
     (childo f m e)
     (== m p))]
   [(fresh [f m]
     (childo f m e)
     (ancestoro f p))]
   [(fresh [f m]
     (childo f m e)
     (ancestoro m p))]))

(defn siblingo [a b]
   (fresh [fa ma fb mb]
     (childo fa ma a)
     (childo fb mb b)
     (== fa fb)
     (== ma mb)))

(defn cousino [e c]
 (conde
   [(fresh [f m sf a b]
     (childo f m e)
     (siblingo f sf)
       (conde
         [(childo sf a c)]
         [(childo b sf c)]))]
   [(fresh [f m sm a b]
     (childo f m e)
     (siblingo m sm)
       (conde
         [(childo sm a c)]
         [(childo b sm c)]))]
   [(fresh [f m]
     (childo f m e)
     (cousino f c))]
   [(fresh [f m]
     (childo f m e)
     (cousino m c))]))


(defn hard_1 [e]
  (with-db facts
   (run* [q]
     (descendanto q e))))

(defn hard_2 [e]
  (with-db facts
   (run* [q]
     (ancestoro e q))))

(defn hard_3 [e]
  (with-db facts
   (run* [q]
     (siblingo e q))))

(defn hard_4 [e]
  (with-db facts
   (run* [q]
     (cousino e q))))

