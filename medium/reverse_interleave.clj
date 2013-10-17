(defn reverse-interleave [xs n]
  {:pre [(pos? n)]}
  (letfn [(aux [i [y & r :as xs] acc]
            (if (seq xs)
              (aux (rem (inc i) n) r (assoc acc i (conj (nth acc i) y)))
              acc))]
    (aux 0 xs (into [] (repeat n [])))))
