(defn closure [n]
  (letfn [(pow [x, i, acc]
            (if (= i 0) acc (pow x (- i 1) (* x acc))))]
    #(pow % n 1)))
