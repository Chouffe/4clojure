(defn get-caps [x]
  (apply str (re-seq #"[A-Z]" x)))
