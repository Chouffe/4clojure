(defn identify [xs]
  (letfn [(aux [xs acc]
    (let [[kw x & more] xs]
      (cond
        (nil? kw) acc
        (and (keyword? kw) (nil? x)) (assoc acc kw (vec (concat (acc kw) [])))
        (keyword? x) (aux (concat [x] more) (assoc acc kw (vec (concat (acc kw) []))))
        :else (if (acc kw)
                (aux (concat [kw] more) (assoc acc kw (conj (acc kw) x)))
                (aux (concat [kw] more) (assoc acc kw [x]))))))]
    (aux xs {})))
