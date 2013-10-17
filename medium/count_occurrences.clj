(defn count-occurences [xs]
  (letfn [(reducer [a i]
            (if (a i)
              (assoc a i (inc (a i)))
              (assoc a i 1)))]
    (reduce reducer {} xs)))
