(defn find-mouse
  "Returns {:i-mouse _ :j-mouse} the position of the mouse"
  [state]
  (let [[[i j]] (filter #(= :mouse (last %))
                  (for [[i line] (map-indexed vector state)
                        [j cell] (map-indexed vector line)]
                    [i j cell]))]
  {:i-mouse i :j-mouse j}))

(defn generate-next-states
  "Generates all the reachable states from the current one (state)"
  [state]
  (letfn [(move-mouse [state i j]
            ;; Generates when possible the state where the mouse is located on (i,j)
            (let [{:keys [i-mouse j-mouse]} (find-mouse state)
                  s (assoc state i-mouse (assoc (state i-mouse) j-mouse :empty))]
              (cond
                (> i (dec (count state))) false
                (> j (dec (count (state 0)))) false
                (or (neg? i) (neg? j)) false
                :else (case ((state i) j)
                        :mouse state
                        :wall false
                        (assoc s i (assoc (s i) j :mouse))))))]
    (let [{:keys [i-mouse j-mouse]} (find-mouse state)]
      (filter (complement false?) (map #(apply (partial move-mouse state) %)
                                       [[i-mouse (inc j-mouse)]
                                        [i-mouse (dec j-mouse)]
                                        [(inc i-mouse) j-mouse]
                                        [(dec i-mouse) j-mouse]])))))
  

(defn bfs [maze]
;; "Converts the array of string into the structure used to represent a state
;; ['M  C'] => [:mouse :empty :empty :cheese]"
  (letfn [(get-state-from-array-of-strings [xs]
            (letfn [(string-to-keyword [s]
                      (case s
                        "C" :cheese
                        "M" :mouse
                        "#" :wall
                        " " :empty))]
              (vec (map (fn [line] (vec (map (comp string-to-keyword str) (seq line)))) xs))))]

          (let [state (get-state-from-array-of-strings maze)]
            (letfn [(done? [state]
                      ;; Checks whether the mouse has reached the cheese
                      (= 0 (count(filter #(= :cheese (last %))
                                         (for [[i line] (map-indexed vector state)
                                               [j cell] (map-indexed vector line)]
                                           [i j cell])))))
                    ;; Auxiliary function (implementing BFS)
                    (aux [visited queue]
                      (let [u (peek queue)]
                        (cond
                          (not (seq queue)) false
                          (and (seq queue) (done? u)) true
                          :else (recur
                                  (conj visited u)
                                  (into (pop queue) (filter #(not (visited %)) (generate-next-states u))))
                          )))]
              (aux #{} [state])))))


;; Tests
(= true  (bfs ["M   C"]))
(= false (bfs ["M # C"]))
(= true  (bfs ["#######"
               "#     #"
               "#  #  #"
               "#M # C#"
               "#######"]))
(= false (bfs ["########"
               "#M  #  #"
               "#   #  #"
               "# # #  #"
               "#   #  #"
               "#  #   #"
               "#  # # #"
               "#  #   #"
               "#  #  C#"
               "########"]))
(= false (bfs ["M     "
               "      "
               "      "
               "      "
               "    ##"
               "    #C"]))
(= true  (bfs ["C######"
               " #     "
               " #   # "
               " #   #M"
               "     # "]))
(= true  (bfs ["C# # # #"
               "        "
               "# # # # "
               "        "
               " # # # #"
               "        "
               "# # # #M"]))
