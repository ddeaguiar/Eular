(ns eular.p2)

(defn fib-step 
  "Generates the next fibonacci number from the passed in fibonacci sequence pair"
  [[a b]]
    [b (+ a b)])

(defn fib-seq
  "Returns a lazy sequence of fibonacci numbers seeded with 0 & 1."
  []
    (map first (iterate fib-step [0 1])))

(defn gen-fibs 
  "Returns the fibonacci sequence up to the passed in limit."
  [limit]
    (take-while #(< % limit) (fib-seq)))

(defn sum-even-fibs 
  "Sums the even fibonacci numbers up to the given in limit."
  [limit]
    (let [fibs (gen-fibs limit)]
      (apply + (filter even? fibs))))
