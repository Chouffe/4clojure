(defn btree? [t]
  (if (empty? t) true
    (let [[a b c :as tree] t]
      (and
        (and
          a
          (not (coll? a)))
           (and
             (= (count tree) 3)
             (and
               (btree? b)
               (btree? c)))))))
