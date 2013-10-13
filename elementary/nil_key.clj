(true?  ((fn [k, m]
          (= (k m :none) nil))
           :a {:a nil :b 2}))
