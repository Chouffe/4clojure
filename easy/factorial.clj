(defn facto [n]
  (if (= n 0) 1
    (* n (facto (- n 1)))))

(defn facto2 [n]
  (reduce * (range 1 (+ n 1))))
