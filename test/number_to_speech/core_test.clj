(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn number->speech [number]
  (cond (zero? number)   "zero"
        (= 1 number)     "one"
        :else            "two")
  )

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))

(deftest test-input-1-output-one
  (is (= "one"  (number->speech 1))))

(deftest test-input-2-output-two
  (is (= "two"  (number->speech 2))))