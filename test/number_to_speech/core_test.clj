(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))