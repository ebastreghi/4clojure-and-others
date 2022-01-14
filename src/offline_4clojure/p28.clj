;; Flatten a Sequence - Easy
;; Write a function which flattens a sequence.
;; tags - seqs:core-functions
;; restricted - flatten
(ns offline-4clojure.p28
  (:use clojure.test))

(defn __ [coll]
(flatten coll)
)

;; The short answer:  the `concat` part of `mapcat` is going to combine all the calls to the `flat` function,
;; starting with the last one which returns `(list x)` and working backwards to the first call.
;; Both `map` and `mapcat` return a lazy sequence.  So actually they dont produce answers until they hit the
;; end of a collection or the end of a recursive function call (when the recursive function call stops calling
;; itself).  So `map` and `mapcat` need some kind of end condition before putting all the results back together.
;; Without an end condition you would just be returned a pointer to a lazy sequence, which could be infinite.
;; So then something around that lazy sequence would need to make it evaluate.

;(concat (list 1 2) (list 3 4))
;=> (1 2 3 4)

(defn my-flatten [x]
  (if (coll? x)
    (mapcat my-flatten x)
    (list x)))

(defn -main []
  (are [soln] soln
(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
(= (__ '((((:a))))) '(:a))
))
