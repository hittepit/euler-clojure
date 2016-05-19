(ns euler.solutions2)

(require '[euler.utils :as utils])

(require '[clojure.string])

(defn solve-euler10
	[]
	(reduce + (take-while #(< % 2000000N) utils/primes)))

(defn solve-euler11
	[]
	(def grid 
		(reduce 
			(fn 
				[acc,l]
				(conj
					acc
					(vec (map (fn [sNumber] (Integer/parseInt sNumber)) (clojure.string/split l #"\s")))
					))
			[]
			(utils/readFile "problem11.txt")))
	(let [
		get-at
			(fn [grid row col] (get (get grid row) col))
		horizontal-products 
			(fn [grid] 
				(for
					[row (range 0 20)
					col (range 0 17)]
					(*' (get-at grid row col)(get-at grid row (+ col 1))(get-at grid row (+ col 2))(get-at grid row (+ col 3)))))
		vertical-products
			(fn [grid] 
				(for
					[row (range 0 17)
					col (range 0 20)]
					(*' (get-at grid row col)(get-at grid (+ row 1) col)(get-at grid (+ row 2) col)(get-at grid (+ row 3) col))))
		left-to-right-products
			(fn [grid]
				(for
					[row (range 0 17)
					col (range 0 17)]
					(*' (get-at grid row col) (get-at grid (+ row 1) (+ col 1)) (get-at grid (+ row 2) (+ col 2)) (get-at grid (+ row 3) (+ col 3)))
				)
			)
		right-to-left-products
			(fn [grid]
				(for
					[row (range 3 20)
					col (range 0 17)]
					(*' (get-at grid row col) (get-at grid (- row 1) (+ col 1)) (get-at grid (- row 2) (+ col 2)) (get-at grid (- row 3) (+ col 3)))
				)
			)
		]

		(max
			(apply max (horizontal-products grid))
			(apply max (vertical-products grid))
			(apply max (left-to-right-products grid))
			(apply max (right-to-left-products grid))
		)
	)
)

(defn solve-euler12
	[]
	(utils/find-first 
			#(> (count (utils/factors %)) 500)
			utils/triangle-numbers-seq))

(defn solve-euler13
	[]
	(.substring 
		(.toString
			(reduce
				+
				(map
					(fn [s] (BigInteger. s))
					(utils/readFile "problem13.txt"))))
		0
		10))

(defn solve-euler14
	[]
	(get
		(reduce
			(fn [v el]
				(let
					[c (utils/collatz-count el)]
					(if
						(> c (get v 0))
						[c el]
						v)))
			[0 0]
			(range 1 1000000)) 
		1))

; A route is composed of right and down moves
; To be correct, it must have two times the grid dimensions moves
; it must have the same number of right and down moves.
; If n x n is the dimensions, it must have 2*n moves with n right moves (and n down moves)
; So, the result is the number of n-combinations in a set 2n elements (C(2n,n))
; 2n!/(n! * n!)
(defn solve-euler15
	[]
	(let [grid 20
		  fact-20 (utils/fact 20)]
		(/ (utils/fact (* grid 2)) (*' fact-20 fact-20))))

(defn solve-euler16
	[]
	(let [s (.toString (utils/exp 2 1000))]
		(reduce 
			+ 
			(map 
				#(Integer/parseInt (str %)) 
				(seq s)))))