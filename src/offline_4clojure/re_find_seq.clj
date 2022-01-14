(ns offline-4clojure.re-find-seq)


;#"" regex format
;^ find in the beginning of the string
(re-find #"^left-" "left-eye")

;only numbers
(re-find #"\d+" "abc12345def")

(re-find #"\d+" "672-345-456-3212")
;"672"

(re-seq #"\d+" "672-345-456-3212")
;=> ("672" "345" "456" "3212")

;re-seq -> Returns a lazy sequence of successive matches of pattern in string
(re-seq #"\d" "clojure 1.1.0")
;("1" "1" "0")

(re-seq #"\w+" "mary had a little lamb")
;("mary" "had" "a" "little" "lamb")
