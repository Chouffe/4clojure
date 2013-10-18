(defn word-sort [s] (sort-by clojure.string/lower-case (seq (re-seq #"\w+" s))))
