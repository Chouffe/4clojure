(defn drop-nth [xs n]
  (letfn [(aux [xs i acc]
          (if (empty? xs) acc
            (if (= i 1) (aux (rest xs) n acc)
              (aux (rest xs) (- i 1) (conj acc (first xs))))))]
    (aux xs n [])))

