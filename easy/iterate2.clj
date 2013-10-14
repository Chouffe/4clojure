; Returns f(x) f(f(x)) ....
(defn iter [f xs]
  (let [[x & r] xs]
    (if (empty? r) []
      (concat (list (f x)) (iter (comp f f) r)))))


(defn iter [f x]
  (letfn [(aux [g]
              (concat (list (g x)) (aux (comp g f))))]
    (aux identity)))

; Returns a seq x, f(x), f(f(x))
(defn iter [f x]
  (reduce (fn [a i] (conj a (f (last a)))) [x] (range 100)))

; Returns a lazy seq x, f(x), f(f(x)) ?? Does not work
(defn iter [f x]
  (reduce (fn [a i] (conj a (f (last a)))) [x] (range)))
