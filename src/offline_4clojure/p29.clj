;; Get the Caps - Easy
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; tags - strings
;; restricted - 
(ns offline-4clojure.p29
  (:use clojure.test))

(def capital-set #{"A" "B" "C" "D" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z"})

(defn ___ [coll]
  (apply str (filter #(capital-set (str %)) (seq coll)))
)

(defn __ [coll]
  (clojure.string/join (re-seq #"[A-Z]+" coll)))

(defn -main []
  (are [soln] soln
(= (__ "HeLlO, WoRlD!") "HLOWRD")
(empty? (__ "nothing"))
(= (__ "$#A(*&987Zf") "AZ")
))
