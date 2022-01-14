(ns offline-4clojure.queue)

(def new-orders clojure.lang.PersistentQueue/EMPTY)

;efficient to add in the end
(defn add-order [orders order]
  (conj orders order))

;efficient to access the beginning
(defn cook-order [orders]
  (cook (peek orders))
  (pop orders))