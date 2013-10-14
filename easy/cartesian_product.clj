(defn cartesian-product [s1 s2]
  (into #{} (for [e1 s1 e2 s2] [e1 e2])))
