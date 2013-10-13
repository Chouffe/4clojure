(defn myrange [from, to]
  (letfn [(aux [from, to, acc]
            (if (> from to)
              []
              (if (= from to)
                acc
                (aux (+ 1 from) to (conj acc from)))))]
    (aux from to [])))
