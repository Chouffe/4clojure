(defn dot-product [xs ys]
  (reduce + (map #(* (first %) (second %)) (map list xs ys))))
