(defn merge-with-function [f m1 & ms]
  (cond
    (seq ms) (let [m2 (first ms)
                   m-new (into m1 
                               (for [[k v] m2]
                                 (if (m1 k)
                                   [k (f (m1 k) v)]
                                   [k v])))]
               (apply (partial merge-with-function f m-new) (rest ms)))
    :else m1))


