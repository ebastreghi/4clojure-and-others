;; Intro to Strings - Elementary
;; Clojure strings are Java strings.  This means that you can use any of the Java string methods on Clojure strings.
;; tags - 
;; restricted - 
(ns offline-4clojure.p3
  (:use clojure.test))

(def __ (.toUpperCase "hello world"))

(defn -main []
  (are [soln] soln
              (= __ (.toUpperCase "hello world"))))

(defn -main2 []
  (are [result soln] (= result soln)
              __ (.toUpperCase "hello world")))