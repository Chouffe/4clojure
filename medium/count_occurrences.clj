(defn count-occurences [xs]
  (letfn [(reducer [a i]
            (if (a i)
              (assoc a i (inc (a i)))
              (assoc a i 1)))]
    (reduce reducer {} xs)))

(defn count-occurences [xs]
  (into {}
        (for [[k v] (group-by identity xs)] [k (count v)])))
