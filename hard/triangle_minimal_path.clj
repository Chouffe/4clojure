;; Dynamic Programming to solve the problem
(defn shortest-path [t]
  (let [cost (build-matrix t)
        inf 10000
        len (dec (count cost))]
  (letfn [(min-cost [m n]
    (cond
      (or (< m 0) (< n 0)) inf
      (zero? m) ((cost m) n)
      :else (+ ((cost m) n) (min (min-cost (dec m) n) (min-cost (dec m) (dec n))))))]
    (apply min (map (partial min-cost len) (range len))))))

;; Converts a triangle into a Matrix
;; [[1] [1 2] [1 2 3]] -> [[1 inf inf] [1 2 inf] [1 2 3]]
(defn build-matrix [triangle]
  (vec
    (let [inf 10000
          m (- (count triangle) 1)]
      (map #(into % (repeat (- m (dec (count %))) inf)) triangle))))

;; Tests
(= 7 (shortest-path [ [1] [2 4] [5 1 4] [2 3 4 5]]))                            ;; True
(= 20 (shortest-path [ [3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]])) ;; True
