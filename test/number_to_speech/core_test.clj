(ns number-to-speech.core-test
  (:use clojure.test
        number-to-speech.core
        ))

(defn digit->speech [number]
  (cond (= 1 number)  "one"
        (= 2 number)  "two"
        (= 3 number)  "three"
        (= 4 number)  "four"
        (= 5 number)  "five"
        (= 6 number)  "six"
        (= 7 number)  "seven"
        (= 8 number)  "eight"
        (= 9 number)  "nine"))

(defn number->speech [number]
  (cond (and (<= 1 number)
             (<= number 9))
        (digit->speech number)

        (= 20 number) "twenty"

        (and (<= 21 number)
             (<= number 29))
        (str (number->speech 20) " " (digit->speech (mod number 10)))

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

(deftest test-input-30-to-39-output-thirty-to-thirtynine
  (is (= "thirty" (number->speech 30)))
  (is (= "thirty one" (number->speech 31)))  
  (is (= "thirty two" (number->speech 32)))
  (is (= "thirty three" (number->speech 33)))
  (is (= "thirty four" (number->speech 34)))
  (is (= "thirty five" (number->speech 35)))
  (is (= "thirty six" (number->speech 36)))
  (is (= "thirty seven" (number->speech 37)))
  (is (= "thirty eight" (number->speech 38)))
  (is (= "thirty nine" (number->speech 39)))
  )
