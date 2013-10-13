(defn is-palindrome [xs]
  (every? (fn [ls] (apply = ls)) (map list xs (reverse xs))))

(defn is-palindrome [xs]
  (every? #(apply = %) (map list xs (reverse xs))))

(defn is-palindrome [xs]
  (= (reverse xs) xs))
