(defproject offline-4clojure "0.1.0-SNAPSHOT"
  :description "I want to use my real editor to solve 4clojure problems"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "0.5.7"]
                 [cheshire "4.0.4"]
                 [org.clojure/math.combinatorics "0.0.3"]]
  :repl-options {:init-ns offline-4clojure.core}
  :main  offline-4clojure.core
  )
