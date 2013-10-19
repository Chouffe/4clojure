(defn bfs [x y]
  ;; State: {:x x :n n}
  (letfn [(generate-next-states [s]
            (let [x (:x s)
                  n (:n s)]
              (set
                (cond
                  (odd? x) (map (fn [x] {:x x :n (inc n)}) ((juxt #(* % 2) #(+ % 2)) x))
                  :else (map (fn [x] {:x x :n (inc n)}) ((juxt  #(* % 2) #(+ % 2) #(/ % 2)) x))))))

          (aux [visited queue]
            (let [u (first queue)]
              (cond
                (= y (:x u)) (:n u)
                (seq queue) (recur
                              (conj visited u)
                              (into (vec (drop 1 queue)) (filter #(not (visited %)) (generate-next-states u))))
                :else visited)))]
    (aux #{} [{:x x :n 1}])))

;; Tests
(= 1 (bfs 1 1))  ;; True
(= 3 (bfs 3 12)) ;; True
(= 3 (bfs 12 3)) ;; True
(= 3 (bfs 5 9))  ;; True
(= 9 (bfs 9 2))  ;; True
(= 5 (bfs 9 12)) ;; True
