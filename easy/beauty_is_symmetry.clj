(defn symm? [t]
  (letfn [(mirror? [[a a1 a2 :as t1] [b b1 b2 :as t2]]
            (if (and (= a b) (nil? a1) (nil? a2) (nil? b1) (nil? b2)) true
              (if (and (not (= a b)) (nil? a1) (nil? a2) (nil? b1) (nil? b2)) false
                (and (= a b) (mirror? t1 t2)))))]
    (mirror? (first (rest t)) (second (rest t)))))
