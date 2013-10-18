(defn sequence-reduction
  ([f [x & r :as xs]] (sequence-reduction f x r))
  ([f x1 [x & r :as xs]] (lazy-seq
                           (cond
                             (seq xs) (concat [x1] (sequence-reduction f (f x1 x) r))
                             :else [x1]))))
