(defn cmp [& fs]
  (letfn [(aux [[f & gs :as fs] & x]
            (if (seq fs)
              (aux gs (apply f x))
              (if (= (count x) 1)
                (first x)
                x)))]
    (partial aux (reverse fs))))

(fn [& fs]
  (fn [& xs]
    (first (reduce #(vector (apply %2 %1)) xs (reverse fs)))))
