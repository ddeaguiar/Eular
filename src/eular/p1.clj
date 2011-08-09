(ns eular.p1)

(defn sum-multiples 
  "Simple solution which sums the multiples of 3 & 5 in the range of 1 - 1000"
  []
    (apply + (filter #(or (= 0 (mod % 3)) 
                        (= 0 (mod % 5)))
                   (range 1 1000))))

(defn is-multiple 
  "Tests if a number is evenly divisible by another number."
  [n d]
    (zero? (mod n d)))

;Really don't like the nested ifs in this implementation
(defn test-factors 
  "Tests if a number is evenly divisible by any of a collection of factors"
  [n [first-factor & more]]
    (if (nil? first-factor) false
              (if (is-multiple n first-factor) true
                  (test-factors n more))))

(defn multiples
  "Returns the multiples of the factors in the given collection"
  [col factors]
    (filter #(test-factors % factors)
            col))

(defn sum-multiples-1 
  "More generalized implementation of sum-multiples"
  [limit factors]
    (apply + (multiples (range 1 limit) factors)))
