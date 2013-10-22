(defn oscilrate [v f & fs]
  (lazy-seq
    (let [u (f v)]
    (concat [v] (apply (partial oscilrate u) (concat fs [f]))))))

