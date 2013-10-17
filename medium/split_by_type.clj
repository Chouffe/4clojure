(defn split-by-type [xs]
  (letfn [(reducer [a i]
            (let [kw (-> i class str keyword)]
              (cond
                (kw a) (assoc a kw (conj (kw a) i))
                :else (into a {kw [i]}))))]
  (for [[k v] (reduce reducer {} xs)] v)))
