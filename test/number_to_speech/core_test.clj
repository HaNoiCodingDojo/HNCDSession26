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

(defn tens->speech [number]
  (cond (= 10 number)  "ten"
        (= 20 number)  "twenty"
        (= 30 number)  "thirty"
        (= 40 number)  "fourty"
        (= 50 number)  "fifty"
        (= 60 number)  "sixty"
        (= 70 number)  "seventy"
        (= 80 number)  "eighty"
        (= 90 number)  "ninety"))

(defn number->speech [number]
  (cond (and (<= 1 number)
             (<= number 9))
        (digit->speech number)

        (= 0 number) "zero"
        (= 100 number) (str (digit->speech 1) " " "hundred")

        (= 11 number)  "eleven"
        (= 12 number)  "twelve"
        (= 13 number)  "thirteen"
        (= 14 number)  "fourteen"
        (= 15 number)  "fifteen"
        (= 16 number)  "sixteen"
        (= 17 number)  "seventeen"
        (= 18 number)  "eighteen"
        (= 19 number)  "nineteen"

        (and (<= 101 number)
             (<= number 199))
        (str (digit->speech 1) " " "hundred" " and " (number->speech (mod number 100))
             )

        (= (mod number 10) 0) (tens->speech number)

        (and (<= 21 number)
             (<= number 99))
        (str (tens->speech (- number (mod number 10))) " "
             (digit->speech (mod number 10)))

        :else "NAN"
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

(deftest test-input-11-to-19-output-eleven-nineteen
  (is (= "eleven" (number->speech 11)))
  (is (= "twelve" (number->speech 12)))
  (is (= "thirteen" (number->speech 13)))
  (is (= "fourteen" (number->speech 14)))
  (is (= "fifteen" (number->speech 15)))
  (is (= "sixteen" (number->speech 16)))
  (is (= "seventeen" (number->speech 17)))
  (is (= "eighteen" (number->speech 18)))
  (is (= "nineteen" (number->speech 19))))

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

(deftest test-input-90-to-99-output-ninety-to-ninetynine
  (is (= "ninety" (number->speech 90)))
  (is (= "ninety one" (number->speech 91)))
  (is (= "ninety two" (number->speech 92)))
  (is (= "ninety three" (number->speech 93)))
  (is (= "ninety four" (number->speech 94)))
  (is (= "ninety five" (number->speech 95)))
  (is (= "ninety six" (number->speech 96)))
  (is (= "ninety seven" (number->speech 97)))
  (is (= "ninety eight" (number->speech 98)))
  (is (= "ninety nine" (number->speech 99)))
  )

(deftest test-input-100-output-one-hundred
  (is (= "one hundred" (number->speech 100))))

(deftest test-input-101-output-one-hundred-and-one
  (is (= "one hundred and one" (number->speech 101))))

(deftest test-input-110-output-one-hundred-and-ten
  (is (= "one hundred and ten" (number->speech 110))))

(deftest test-input-120-to-129-output-one-hundred-and-twenty-to-one-hundred-and-twenty-nine
  (is (= "one hundred and twenty" (number->speech 120)))
  (is (= "one hundred and twenty one" (number->speech 121)))
  (is (= "one hundred and twenty two" (number->speech 122)))
  (is (= "one hundred and twenty three" (number->speech 123)))
  (is (= "one hundred and twenty four" (number->speech 124)))
  (is (= "one hundred and twenty five" (number->speech 125)))
  (is (= "one hundred and twenty six" (number->speech 126)))
  (is (= "one hundred and twenty seven" (number->speech 127)))
  (is (= "one hundred and twenty eight" (number->speech 128)))
  (is (= "one hundred and twenty nine" (number->speech 129)))
)