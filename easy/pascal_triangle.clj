(defn pascal [n]
  (letfn [(aux [i acc]
            (when (= i 1) [1])
            (when (= i 2) [1 1])
            (if (= i n) acc
              (aux
                (+ i 1)
                (cons 1 (conj (vec (map #(+ (first %) (second %)) (partition 2 1 acc))) 1)))))]
    (aux 1 [1])))
