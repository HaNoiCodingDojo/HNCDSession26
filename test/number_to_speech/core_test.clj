(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn number->speech [number]
  (cond (= 0 number)  "zero"
        (= 1 number)  "one"
        (= 2 number)  "two"
        (= 3 number)  "three")
  )

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))

(deftest test-input-1-to-9-output-one-to-nine
  (is (= "one"  (number->speech 1)))
  (is (= "two"  (number->speech 2)))
  (is (= "three" (number->speech 3)))
  )
