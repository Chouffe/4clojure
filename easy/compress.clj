(defn compress [xs]
  (reduce #(if (= (last %1) %2) %1 (conj %1 %2)) [] xs))
