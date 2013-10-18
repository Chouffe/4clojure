(defn juxtaposition [& fs]
  (letfn [(aux [[f & gs :as fs] & x]
           (when (seq fs)
             (concat [(apply f x)] (apply (partial aux gs) x))))]
    (partial aux fs)))

(fn [& x] (fn [& a] (map #(apply % a) x)))
