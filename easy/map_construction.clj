(defn map-constructor [ke va]
  (reduce (fn [a, [k v]] (assoc a k v)) {} (map list ke va)))

(defn map-constructor [ke va] (zipmap ke va))
