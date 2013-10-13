(defn interp [i xs]
  (rest (flatten (map #(seq [i %]) xs))))
