(defn to-decimal [bin]
  (reduce
    #(+ %1 (* (first %2) (second %2)))
    0
    (map list
         (iterate #(* 2 %) 1)
         (reverse (map read-string (re-seq #"\d" bin))))))
