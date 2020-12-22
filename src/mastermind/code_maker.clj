(ns mastermind.code-maker)

(def count-if (comp count filter))

(defn position-matches [code guess]
  (count-if true? (map = code guess)))

(defn value-matches [code guess]
  (count-if (set code) guess))

(defn count-of [value values]
  (count (filter #(= value %) values)))

(defn over-count [code guess]
  (->> (set code)
       (map #(- (count-of % guess) (count-of % code)))
       (filter pos?)
       (reduce +)))

(defn score [code guess]
  (let [position (position-matches code guess)
        value (value-matches code guess)
        over (over-count code guess)]
    [position (- value position over)]))
