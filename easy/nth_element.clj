(defn nth_element [xs, n]
  (letfn [(aux [xs, i]
            (if (= i 0)
              (first xs)
              (aux (rest xs), (- i 1))))]
    (aux xs n)))
            
