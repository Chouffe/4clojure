(defn find-distinct [xs]
  (letfn [(aux [[x & y :as xs] s acc]
            (if (seq xs)
              (cond
                (s x) (recur y s acc)
                :else (recur y (conj s x) (conj acc x)))
              acc))]
    (aux xs #{} [])))
