;; Fibonacci Sequence - Easy
;; Write a function which returns the first X fibonacci numbers.
;; tags - Fibonacci:seqs
;; restricted -

;In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, the Fibonacci sequence,
;in which each number is the sum of the two preceding ones. The sequence commonly starts from 0 and 1,
;although some authors omit the initial terms and start the sequence from 1 and 1 or from 1 and 2. Starting from 0 and 1,
;the next few values in the sequence are:[1]
;0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...

(ns offline-4clojure.p26
  (:use clojure.test))

(defn __ [length-fibonacci]
(loop [init-vector [1 1]
       length-fib (- length-fibonacci 2)]
  (if (= 0 length-fib)
    init-vector
    (let [butlast-item (last (butlast init-vector))
          last-item (last init-vector)]
    (recur (conj init-vector (+ butlast-item last-item))
           (- length-fib 1))))))

(defn fib
  ([] (fib 1 1))
  ([butlast-i last-i] (lazy-seq (cons butlast-i (fib last-i (+ last-i butlast-i))))))


(defn -main []
  (are [soln] soln
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21))))

