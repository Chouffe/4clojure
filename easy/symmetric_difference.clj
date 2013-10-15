(defn symmetric-diff [s1 s2]
  (clojure.set/difference (clojure.set/union s1 s2) (clojure.set/intersection s1 s2)))
