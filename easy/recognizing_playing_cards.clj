(defn recognize [card]
  (let [suit {:D :diamond :H :heart :C :club :S :spade}
        rank {:2 0 :3 1 :4 2 :5 3 :6 4 :7 5 :8 6 :9 7 :T 8 :J 9 :Q 10 :K 11 :A 12}
        c (re-seq #"\w" card)
        s (suit (keyword (first c)))
        r (rank (keyword (second c)))]
    {:suit s :rank r}))
