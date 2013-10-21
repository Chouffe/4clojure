(defn balanced? [n]
  (let [xs (map (comp read-string str) (str n))
        l (count xs)]
    (= (reduce + (take (/ l 2) xs)) (reduce + (take (/ l 2) (reverse xs))))))
    
