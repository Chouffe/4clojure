(->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
