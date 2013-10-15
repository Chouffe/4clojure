(defn pairwise_disjoint [s]
  (let [combined-set (reduce (fn [x y] (if (x y) (assoc x y (+ (x y) 1)) (assoc x y 1))) {} (for [e s f e] f))]
    (every? #(= % 1) (for [[k v] combined-set] v))))
