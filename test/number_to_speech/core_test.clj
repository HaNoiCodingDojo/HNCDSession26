(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn number->speech [number]
  "zero")

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))
