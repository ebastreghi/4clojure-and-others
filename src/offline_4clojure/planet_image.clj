(ns offline-4clojure.planet-image
  (:require [clojure.java.io :as io])
  (:import [javax.imageio ImageIO]
           [java.awt.image BufferedImage]))

(defrecord PlanetImage [src ^BufferedImage contents])

;constructor functions are useful when one of your domain entities is imported from Java
(defn make-planet-image [src]
  (with-open [img (ImageIO/read (io/input-stream src))]
    (->PlanetImage src img)))
