(ns offline-4clojure.map-comparator)

(defn compare-author-lname [s1 s2]
  (compare (:lname s1) (:lname s2)))

(defn compare-author [s1 s2]
  (letfn [(project-author [author]
            ((juxt :lname :fname) author))]
    (compare (project-author s1) (project-author s2))))

(sorted-set-by compare-author
               {:fname "Edevar" :lname "Bastreghi"}
               {:fname "Danila" :lname "Bastreghi"})