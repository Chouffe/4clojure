; First Try
(defn map-defaults [i, m]
  (reduce (fn [acc, it] (conj acc [it i])) {} m))

; Improved
(defn map-defaults [i, m] (reduce #(conj %1 [%2 i]) {} m))

(= (map-defaults 0 [:a :b :c]) {:a 0 :b 0 :c 0})
