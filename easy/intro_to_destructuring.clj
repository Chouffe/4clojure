(= [2 4] (let [[a b c d e f g] (range)] [c e]))

(defn test1 [[a b c & d :as full]]
  (str "a: " a "b: " b "c: " c "d: " d " full: " full))
(test1 [1 2 3 4 5])
