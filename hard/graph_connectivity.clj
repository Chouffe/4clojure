;; Build an Incidence Matrix representation
(defn build-g [s]
  ;; (build-g #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]})
  ;; => {:x [:y :a], :y [:x], :b [:c :a :e], :c [:b :d], :a [:x :b :d], :d [:c :a], :e [:b]}
  (letfn [(add-directed-edge-into-graph [[u v :as edge] g]
            ;; #{[:a :b] [:b :c]} => #{:a [:b] :b [:c]}"
            (let [key-u (g u)]
              (if key-u (assoc g u (conj key-u v))
                (assoc g u [v]))))
          (add-undirected-edge-into-graph [[u v] g]
            ;; #{[:a :b] [:b :c]} => #{:a [:b] :b [:a :c] :c [:b]}"
            (add-directed-edge-into-graph [u v] (add-directed-edge-into-graph [v u] g)))]
    (reduce #(into %1 (add-undirected-edge-into-graph %2 %1)) {} (seq s))))

;; Breadth-First-Search returning true or false if the graph is fully connected
(defn bfs [edge-set]
  (let [g (build-g edge-set)]
    ;; Auxiliary function (implementing BFS)
    (letfn [(aux [visited queue]
              (let [u (peek queue)]
                (cond
                  (seq queue) (recur
                                (conj visited u)
                                (into (pop queue) (filter #(not (visited %)) (g u))))
                  :else visited)))]
      (= (set (keys g)) (aux #{} [(first (first g))])))))

;; Unit Tests
(= true (bfs #{[:a :a]}))                                                 ;; True
(= true (bfs #{[:a :b]}))                                                 ;; True
(= false (bfs #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]}))                    ;; True
(= true (bfs #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]}))               ;; True
(= false (bfs #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e]}))        ;; True
(= true (bfs #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]})) ;; True
