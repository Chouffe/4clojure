(defn repli [xs n]
  (flatten (map #(repeat n %) xs)))
