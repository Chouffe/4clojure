; First implementation
(defn fibo [n]
  (case n
    0 1
    1 1
    (+ (fibo (- n 1)) (fibo (- n 2)))))

; Tail Optimization
(defn fibo2 [n]
  (letfn [(aux [n, i, j]
            (if (= n 0) (+ 0 i) (aux (- n 1) j, (+ i j))))]
    (aux n 0 1)))

; Could do a memoization to avoid exponential complexity
#(map (fn fibo [n]
        (case n
          0 1
          1 1
          (+ (fibo (- n 1)) (fibo (- n 2))))) (range %))


