(ns offline-4clojure.medley1
  (:require [medley.core :refer [map-keys map-vals]]
            [clojure.string :as str]))

;medley apply transient that improve the performance

(def map-from-db {"name" "Earth"
                  "moons" 1})

;convert every map key in keyword
(map-keys keyword map-from-db)

(def map-with-keys (map-keys keyword map-from-db))

(def vec-of-maps [{"name" "Earth"
                   "const" 2
                   "moons" 1}
                  {"name" "Saturn"
                   "const" 3
                   "moons" 2}])

(defn add-new-key-val [map-item]
  (assoc map-item :mass (* (:const map-item) 15)))

(map-vals add-new-key-val (map #(map-keys keyword %) vec-of-maps))

(map-vals prn {:name "Edevar"
               :idade 35
               :filho {:nome "Benicio" :idade 5}})
;"Edevar"
;35
;{:nome "Benicio", :idade 5}


(map-vals str/upper-case {:name  "Edevar"
                          :idade 35
                          :filho {:nome "Benicio" :idade 5}})
;{:name "EDEVAR", :idade "35", :filho "{:NOME \"BENICIO\", :IDADE 5}"}

;with recursion and map-vals, I was able to transverse all the vals and apply the function
(defn my-own-upper [item]
  (if (map? item)
    (map-vals my-own-upper item)
    (str/upper-case item)))

(map-vals my-own-upper {:name  "Edevar"
                          :idade 35
                          :filho {:nome "Benicio" :idade 5}})
;{:name "EDEVAR", :idade "35", :filho {:nome "BENICIO", :idade "5"}}