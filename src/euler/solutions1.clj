(ns euler.solutions1
	(:require [euler.utils :as utils]))

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
			int-under-borne (take-while #(<= % borne) utils/int-seq)
			small-n-factors 
				(filter 
					#(and 
						(not (= 0 %))
						(= (mod n %) 0)) 
					int-under-borne)
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

(defn solve-euler7
	[]
	(nth (utils/primes)  10000))

(def digit1000 "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450")

(defn solve-euler8
	[]
	(let [regroup (fn [x]
		(loop [acc [] digit-rest x]
			(if (< (count digit-rest) 13)
				acc
				(recur (cons (reduce * 1 (take 13 digit-rest)) acc) (rest digit-rest))
				)))]
	(apply max 
		(regroup 
			(map 
				#(bigint (str %)) 
				(seq digit1000)
				)))
		))

(defn solve-euler9
	[]
	(first (for [x (range 501)
			y (range 501)
			:let [z (- 1000 (+ x y))
					x2 (* x x)
					y2 (* y y)
					z2 (* z z)]
			:when (and 
				(< x y)
				(< y z)
				(= z2 (+ x2 y2)))]
			(* x y z)))
)
