(ns euler.solutions2)

(require '[euler.utils :as utils])

(defn solve-euler10
	[]
	(reduce + (take-while #(< % 2000000N) (utils/primes))))