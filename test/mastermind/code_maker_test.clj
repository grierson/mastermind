(ns mastermind.code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts "position matches"
  (fact "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [0 0])
  (fact "score guess with one position match"
    (score [0 0 0 0] [0 1 1 1]) => [1 0]
    (score [0 0 0 0] [1 1 1 0]) => [1 0])
  (fact "guess with two position matches"
    (score [0 0 0 0] [0 0 1 1]) => [2 0]
    (score [0 0 0 0] [0 1 1 0]) => [2 0])
  (fact "guess with all position matches"
    (score [1 2 3 4] [1 2 3 4]) => [4 0]))

(facts "value matches"
  (fact "one value match"
    (score [1 2 3 4] [0 0 0 1]) => [0 1])
  (fact "two value matches"
    (score [1 2 3 4] [0 0 2 1]) => [0 2])
  (fact "three value matches"
    (score [1 2 3 4] [0 3 2 1]) => [0 3])
  (fact "four value matches"
    (score [1 2 3 4] [4 3 2 1]) => [0 4]
    (score [1 2 3 4] [2 1 4 3]) => [0 4]))

(fact "two positions and two values"
  (score [1 2 3 4] [1 2 4 3]) => [2 2])

(fact "duplicate colours within guess"
  (score [1 0 0 0] [2 1 1 1]) => [0 1]
  (score [1 2 3 4] [3 3 3 4]) => [2 0]
  (score [1 2 3 4] [4 3 3 4]) => [2 0]
  (score [1 2 3 4] [4 4 3 4]) => [2 0])
