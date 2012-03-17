(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn number->speech [number]
  "zero")

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))

(deftest test-input-1-output-one
  (is (= "one"  (number->speech 1))))