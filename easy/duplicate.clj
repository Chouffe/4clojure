(defn duplicate [xs]
  (reduce #(conj %1 %2 %2) [] xs))
