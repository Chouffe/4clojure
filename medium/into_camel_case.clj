(defn into-camel-case [s]
  (reduce #(str %1 (clojure.string/capitalize %2)) (re-seq #"\w+" s)))
