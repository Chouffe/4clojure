(defn myflatten [xs]
  (reduce #(concat %1 (if (list? %2) (myflatten %2) (list %2))) '() xs))
