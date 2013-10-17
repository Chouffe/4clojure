(defn cmp [f & more]
  (letfn [(aux [x]
            (-> x (apply f more)))]
    aux))

(defn cmp [& fs]
  (letfn [(aux [[f & gs :as fs] & x]
            (if (seq fs)
              (aux gs (apply f x))
              (if (= (count x) 1)
                (first x)
                x)))]
    (fn [& x] (apply #(aux (reverse fs) %) x))))

(defn cmp [& fs]
  (letfn [(aux [[f & gs :as fs] & x]
            (if (seq fs)
              (aux gs (apply f x))
              (if (= (count x) 1)
                (first x)
                x)))]
    (partial aux (reverse fs))))
