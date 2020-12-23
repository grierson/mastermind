(ns mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-breaker :refer :all]))

(facts "Code Breaker"
  (fact "guess-to-number"
    (guess->number [0 0 0 0]) => 0
    (guess->number [0 0 0 1]) => 1
    (guess->number [5 5 5 5]) => (dec (* 6 6 6 6)))

  (fact "number to guess"
    (number->guess 0) => [0 0 0 0]
    (number->guess (dec (* 6 6 6 6))) => [5 5 5 5])

  (fact "increment guess"
    (inc-guess [0 0 0 0]) => [0 0 0 1]
    (inc-guess [5 5 5 5]) => [0 0 0 0])

  (fact "initial guess"
    (break-code nil []) => [0 0 0 0])

  (fact "first step for [1 2 3 4]"
    (break-code [0 0 0 0]
                [[[0 0 0 0] [0 0]]]) => [1 1 1 1])

  (fact "first step for [0 0 0 1]"
    (break-code [0 0 0 0]
                [[[0 0 0 0] [3 0]]]) => [0 0 0 1])

  (fact "first step for [0 0 1 0]"
    (break-code [0 0 0 1]
                [[[0 0 0 1] [2 2]]]) => [0 0 1 0])

  (fact "two steps for [0 0 1 0]"
    (break-code [0 0 0 0]
                [[[0 0 0 0] [3 0]]
                 [[0 0 0 1] [2 2]]]) => [0 0 1 0]))

