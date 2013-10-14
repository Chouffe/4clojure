(defn split [at xs]
  (letfn [(aux [i xs acc]
            (if (= i 0) (conj (vec (list acc)) xs)
              (aux (- i 1) (rest xs) (conj acc (first xs)))))]
    (aux at xs [])))

(defn split2 [at xs]
  (conj (vec (list (take at xs))) (drop at xs)))

(defn split3 [at xs]
  (conj (-> (take at xs) list vec) (drop at xs)))

(defn split4 [at xs]
  (conj ((comp vec list) (take at xs)) (drop at xs)))
