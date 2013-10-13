(defn rev [xs]
  (letfn [(aux [xs, acc]
            (if (empty? xs)
              (seq acc)
              (aux (rest xs) (conj acc (first xs)))))]
    (aux xs '())))

(defn rev2 [xs]
  (reduce (fn [a, i] (conj a i)) '() xs))
