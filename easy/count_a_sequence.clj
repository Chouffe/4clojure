(defn count_a_sequence [xs]
  (if (empty? xs)
    (+ 0 0)
    (+ 1 (count_a_sequence (rest xs)))))

(defn count_a_sequence2 [xs]
  (reduce (fn [a, i] (+ a 1)) 0 xs))
