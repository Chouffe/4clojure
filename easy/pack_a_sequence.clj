; Does not work...
(defn pack [xs]
  (let [h (reduce (fn [a, i] (if (a i) (assoc a i (+ (a i) 1)) (assoc a i 1))) {} xs)]
   (reverse (for [[k v] h] (repeat v k)))))

; Other Try
(defn pack [xs]
  (partition-by identity xs))
