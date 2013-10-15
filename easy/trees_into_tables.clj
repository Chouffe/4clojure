(defn flattenize [h]
  (into {} (for [[k v] h
        [k2 v2] v]
    [[k k2] v2])))
