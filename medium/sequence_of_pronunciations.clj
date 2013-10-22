(defn seq-of-pron [xs]
  (let [f
    (let [& comp
          p partial]
      (& flatten
         (p map #(list (count %) (first %)))
         (p partition-by identity)))]
    (iterate f (f xs)))) 

(take 3 (seq-of-pron [1]))
