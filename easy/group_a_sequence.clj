(defn group-a-sequence [f xs]
  (reduce (fn [a i]
            (let [fi (f i)]
              (if (contains? a fi)
                (assoc a fi (conj (a fi) i))
                (assoc a fi [i]))))
         {} xs)) 
