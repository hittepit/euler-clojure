(ns euler.solutions)

(require '[euler.utils :as utils])

(defn solve-euler1 []
 	(reduce 
 		+ 
 		(filter  
 			#(or 
 				(== (mod % 3) 0) 
 				(== (mod % 5) 0)
 			)
 			(range 1000)
 		)
 	)
)

(defn solve-euler2 []
	(reduce
		+
		(filter
			#(== (mod % 2) 0)
			(take-while
				#(< % 4000000)
				utils/fibo-seq
			)
		)
	)
)

(defn solve-euler3
	[]
	(
		let [n 600851475143N
			borne (Math/sqrt n)
			int-under-borne (take-while #(<= % borne) (utils/int-seq 1))
			small-n-factors (filter #(= (mod n %) 0) int-under-borne)
			big-n-factors (map #(/ n %) small-n-factors)
			answer (first (filter utils/prime? (concat big-n-factors (reverse small-n-factors))))]

		answer
	)
)

(defn solve-euler4
	[]
	(apply max (filter utils/palindrome? (flatten (
		map 
			(fn [x] 
				(map #(* % x) (range 999 99 -1)))
			(range 999 99 -1)
		))))
)

(defn solve-euler5
	[]
	(reduce utils/gcm 1 (range 1 21))
)

(defn solve-euler6
	[]
	(-
		(let [x (reduce + (range 101))]
			(* x x))
		(reduce 
			+ 
			(map #(* % %) (range 101))))
)