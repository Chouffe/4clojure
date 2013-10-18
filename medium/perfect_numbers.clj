(defn divisors [n]
  (filter #(= 0 (rem n %)) (range 1 n)))

(defn perfect? [n]
  (let [divisors (filter #(= 0 (rem n %)) (range 1 n))]
    (= n (reduce + divisors))))
