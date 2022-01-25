(ns offline-4clojure.iterate)

(take 3 (iterate inc 5))
;(5 6 7)

(take 10 (iterate (partial + 2) 0))
;(0 2 4 6 8 10 12 14 16 18)