(defn prod-digit [x y]
  (map #(Integer/parseInt %) (re-seq #"\d" (str (* x y)))))

(defn prod-digit [x y]
  (map #(read-string %) (re-seq #"\d" (str (* x y)))))
