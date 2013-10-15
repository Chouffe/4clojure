(defn cnt [xs]
  (letfn [(smaller [n]
            (< n (reduce + (map (comp #(* % %) read-string) (re-seq #"\d" (str n))))))]
    (reduce (fn [x y] (+ x 1)) 0 (filter smaller xs))))
