(ns offline-4clojure.money-book
  (:import java.net.FileNameMap))


(declare validate-same-currency)

(defrecord Currency [divisor sym desc])

(defrecord Money [amount ^Currency currency]
  java.lang.Comparable
  (compareTo [m1 m2]
    (validate-same-currency m1 m2)
    (compare (:amount m1) (:amount m2))))

(def currencies {:usd (->Currency 100 "USD" "US Dollars")
                 :eur (->Currency 100 "EUR" "Euro")})

;we also need functions for adding, comparing, multiplying and other operations

(defn- validate-same-currency [m1 m2]
  (or (= (:currency m1) (:currency m2))
      (throw (ex-info "Currency does not match." {:m1 m1 :m2 m2}))))

(defn =$
  ([m1] true)
  ([m1 m2] zero? (.compareTo m1 m2))
  ([m1 m2 & monies] (every? zero? (map #(.compareTo m1 %) (conj monies m2)))))

(defn +$
  ([m1] m1)
  ([m1 m2]
   (validate-same-currency m1 m2)
   (->Money (+ (:amount m1) (:amount m2)) (:currency m1)))
  ([m1 m2 & monies]
   (reduce +$ m1 (conj monies m2))))

(defn *$ [m n]
  (->Money (* n (:amount m)) (:currency m)))

(defn make-money
  ([] (make-money 0))
  ([amount] (make-money amount (:usd currencies)))
  ([amount currency] (->Money amount currency)))

(make-money)
(make-money 1)
(make-money 5 (:eur currencies))







;; Define a record named Thing with a single field a.  Implement
;; FileNameMap interface and provide an implementation for the single
;; method:  String getContentTypeFor(String fileName)
(defrecord Thing [a]
  FileNameMap
  (getContentTypeFor [this fileName] (str a "-" fileName)))

;; construct an instance of the record
(def thing (Thing. "foo"))
;; check that the instance implements the interface
(instance? FileNameMap thing)