(defn inters [s1 s2]
  (set (filter #(contains? s2 %) s1)))
