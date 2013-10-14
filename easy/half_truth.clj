(defn half-truth [& xs]
  (and (if (nil? (some true? xs)) false true) (not (every? true? xs))))

(= false (half-truth false false))
(= true (half-truth true false))
