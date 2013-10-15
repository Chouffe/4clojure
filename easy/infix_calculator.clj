(defn infix-calculator [& args]
  (letfn [(aux [acc & more]
            (if (empty? more) acc
              (let [op (first more) y (second more)]
                (apply aux (cons (op acc y) (rest (rest more)))))))]
    (apply aux args)))
