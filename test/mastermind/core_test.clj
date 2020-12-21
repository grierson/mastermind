(ns mastermind.core-test
  (:require [midje.sweet :refer :all]
            [mastermind.core :refer :all]))

(facts "Code Breaker"
  (fact "initial guess"
    (break-code []) => [0 0 0 0]))

