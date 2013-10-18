(defn permutation? [s1 s2]
  (let [c1 (count s1)
        c2 (count s2)
        f (comp (partial group-by identity)
                (partial map str)
                seq)]
    (cond
      (not (= c1 c2)) false
      (zero? c1) true
      :else (= (f s1) (f s2)))))

(defn find-anagram [e xs]
  (let [a (into #{e} ((group-by (partial permutation? e) xs) true))]
    (if (> (count a) 1)
      a
      nil)))

(defn find-them-all [xs]
  (letfn [(permutation? [s1 s2]
            (let [c1 (count s1)
                  c2 (count s2)
                  f (comp (partial group-by identity)
                          (partial map str)
                          seq)]
              (cond
                (not (= c1 c2)) false
                (zero? c1) true
                :else (= (f s1) (f s2)))))
          (find-anagram [e xs]
            (let [a (into #{e} ((group-by (partial permutation? e) xs) true))]
              (if (> (count a) 1)
                a
                nil)))]
    (set (remove nil? (reduce #(into %1 [(find-anagram %2 xs)]) #{} xs)))))

;; Much more concise
(defn find-them-all [words]
  (set
    (filter #(< 1 (count %))
      (map
        (fn [word]
          (set
            (filter #(= (group-by identity word) (group-by identity %)) words)))
        words))))
