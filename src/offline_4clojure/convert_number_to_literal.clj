(ns offline-4clojure.convert-number-to-literal)


;convert to literal numbers between 1 and 1001

(def base-map {:1 "one"
               :2 "two"
               :3 "three"
               :4 "four"
               :5 "five"
               :6 "six"
               :7 "seven"
               :8 "eight"
               :9 "nine"
               :10 "ten"
               :11 "eleven"
               :12 "twelve"
               :13 "thirteen"
               :14 "fourteen"
               :15 "fifteen"
               :16 "sixteen"
               :17 "seventeen"
               :18 "eighteen"
               :19 "nineteen"
               :20 "twenty"
               :30 "thirty"
               :40 "fourty"
               :50 "fifty"
               :60 "sixty"
               :70 "seventy"
               :80 "eighty"
               :90 "ninety"
               })

(def base-map-decimal {:2 "twenty"
                       :3 "thirty"
                       :4 "fourty"
                       :5 "fifty"
                       :6 "sixty"
                       :7 "seventy"
                       :8 "eighty"
                       :9 "ninety"})

(defn recur-number [number]
  (cond (> number 999) {:ready (srt (quot number 1000) "thousand") :rest (- number (* (quot number 1000) 1000))}
        (> 99) {:ready (srt (quot number 100) "hundred") :rest (- number (* (quot number 100) 100))}
        (> 19) {:ready ((keyword (str (quot number 10))) base-map-decimal) :rest (- number (* (quot number 100) 100))}
        :else {:ready ((keyword (str number)) base-map)}))

(defn convert-number-to-word [number]
  (loop [acc-word ""
         number-rec number]
    (if ()
      (let [map-number-rest (recur-number number-rec)]

        (recur (:ready map-number-rest)
               (:rest map-number-rest))))))