(defn penultimate
  ([] nil)
  ([xs] (let [tl (rest xs)]
          (if (empty? tl)
            nil
            (if (empty? (rest tl))
              (first xs)
              (penultimate tl))))))
