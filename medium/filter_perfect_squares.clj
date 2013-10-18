(defn filter-perfect-square [s]
  (letfn [(square? [n]
            (contains? (into #{1} (map (fn [x] (* x x)) (range 1 n))) n))]
    (clojure.string/join "," (map str (filter square? (map read-string (re-seq #"\d+" s)))))))
