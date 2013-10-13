(fn mylast
  ([] nil)
  ([xs] (if (empty? (rest xs)) (first xs) (mylast (rest xs)))))

