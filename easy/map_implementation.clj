; Raises a StackOverflow...
(defn mymap [f xs]
  (if (empty? xs) (list)
    (concat (list (f (first xs))) (mymap f (rest xs)))))

; As Well...
(defn mymap [f xs]
  (letfn [(aux [acc xs]
            (if (empty? xs) acc
                (aux (cons (f (first xs)) acc) (rest xs))))]
   (reverse (aux '() xs)))) 
