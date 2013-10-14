(defn compar [less x y]
  (if (less x y) :lt 
    (if (less y x) :gt
      :eq)))
