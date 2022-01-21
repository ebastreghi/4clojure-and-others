(ns offline-4clojure.split)


;; This is because the split happens at the first false/nil predicate result.
;; Your predicate should thus return false upon hitting the desired split value!
(split-with (complement #{:c}) [:a :b :c :d])
;[(:a :b) (:c :d)]

(str/split "q1w2e3r4t5y6u7i8o9p0" #"\d+")
;["q" "w" "e" "r" "t" "y" "u" "i" "o" "p"]

(str/split "q1w2e3r4t5y6u7i8o9p0" #"\d+" 5)
;["q" "w" "e" "r" "t5y6u7i8o9p0"]

(split-at 2 [1 2 3 4 5])
;[(1 2) (3 4 5)]