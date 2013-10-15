(defn pascal-trapezoid [row]
  (letfn [(f [roww] (conj (vec (cons (first roww) (map #(+ (first %) (second %)) (partition 2 1 roww)))) (last roww)))]
    (iterate f row)))

