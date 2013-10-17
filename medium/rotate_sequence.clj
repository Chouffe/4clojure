(defn rotate [n xs]
  (cond
    (= n 0) xs
    (> n 0) (rotate (dec n) (conj (vec (rest xs)) (first xs)))
    :else (rotate (inc n) (cons (last xs) (pop (vec xs)) )))) 
