(defn iter [f x]
  ; To be improved by Memoization...
  (letfn [(compo [n]
            (reduce (fn [a i] (f a)) x (range n)))]
  (for [i (range)] (compo i))))
