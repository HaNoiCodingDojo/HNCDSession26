(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn number->speech [number]
  (cond (= 1 number)  "one"
        (= 2 number)  "two"
        (= 3 number)  "three"
        (= 4 number)  "four"
        (= 5 number)  "five"
        (= 6 number)  "six"
        (= 7 number)  "seven"
        (= 8 number)  "eight"
        (= 9 number)  "nine"
        (= 20 number) "twenty"
        (= 21 number) (str (number->speech 20) " " (number->speech 1))
        (= 22 number) (str (number->speech 20) " " (number->speech 2))
        (= 23 number) (str (number->speech 20) " " (number->speech 3))
        (= 24 number) (str (number->speech 20) " " (number->speech 4))
        (= 25 number) (str (number->speech 20) " " (number->speech 5))
        (= 26 number) (str (number->speech 20) " " (number->speech 6))
        (= 27 number) (str (number->speech 20) " " (number->speech 7))
        (= 28 number) (str (number->speech 20) " " (number->speech 8))
        (= 29 number) (str (number->speech 20) " " (number->speech 9))
        :else "zero"
        )
  )

(deftest test-input-0-output-zero
  (is (= "zero" (number->speech 0))))

(deftest test-input-1-to-9-output-one-to-nine
  (is (= "one"  (number->speech 1)))
  (is (= "two"  (number->speech 2)))
  (is (= "three" (number->speech 3)))
  (is (= "four" (number->speech 4)))
  (is (= "five" (number->speech 5)))
  (is (= "six" (number->speech 6)))
  (is (= "seven" (number->speech 7)))
  (is (= "eight" (number->speech 8)))
  (is (= "nine" (number->speech 9)))
  )

(deftest test-input-20-output-twenty
  (is (= "twenty" (number->speech 20)))
  )

(deftest test-input-21-to-29-output-twenty-one-to-twenty-nine
  (is (= "twenty one" (number->speech 21)))
  (is (= "twenty two" (number->speech 22)))
  (is (= "twenty three" (number->speech 23)))
  (is (= "twenty four" (number->speech 24)))
  (is (= "twenty five" (number->speech 25)))
  (is (= "twenty six" (number->speech 26)))
  (is (= "twenty seven" (number->speech 27)))
  (is (= "twenty eight" (number->speech 28)))
  (is (= "twenty nine" (number->speech 29)))
  )
