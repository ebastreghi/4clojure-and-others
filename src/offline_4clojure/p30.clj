;; Compress a Sequence - Easy
;; Write a function which removes consecutive duplicates from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p30
  (:use clojure.test))

(defn next-is-equal? [elem coll]
  (= elem (first coll)))

(defn remove-consecutive [coll]
  (loop [first-elem (first coll)
         coll-rest (rest coll)
         acc []]
    (if (some? first-elem)
      (recur (if (next-is-equal? first-elem coll-rest) first-elem (first coll-rest))
             (rest coll-rest)
             (if (= first-elem (last acc)) acc (conj acc first-elem)))
      acc)))

(defn __ [coll] (remove-consecutive coll))

(defn -main []
  (are [soln] soln
(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
))

