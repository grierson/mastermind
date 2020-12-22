(ns mastermind.code-breaker)

(defn guess->number [guess]
  (reduce #(+ (* 6 %1) %2) guess))

(defn number->guess [number]
  [(rem (quot number 216) 6)
   (rem (quot number 36) 6)
   (rem (quot number 6) 6)
   (rem number 6)])

(defn inc-guess [guess]
  (-> guess
      guess->number
      inc
      number->guess))


(defn break-code [last-guess past-guesses]
  (if (nil? last-guess)
    [0 0 0 0]
    [1 1 1 1]))

