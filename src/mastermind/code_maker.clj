(ns mastermind.code-maker)

(def count-if (comp count filter))

(defn position-matches [code guess]
  (count-if true? (map = code guess)))

(defn value-matches [code guess]
  (count-if (set code) guess))

(defn score [code guess]
  (let [position (position-matches code guess)
        value (value-matches code guess)]
    [position (- value position)]))



(filter #{1 2 3} [3 3])