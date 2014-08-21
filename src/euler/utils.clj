(ns euler.utils)

(def fibo-seq 
  (
  	(fn rfib 
  		[a b] 
  		(lazy-seq 
  			(cons 
  				a 
  				(rfib 
  					b 
  					(+ a b)
  				)
  			)
  		)
  	)
   	0 1
  )
)

(defn int-seq
  [start]
  ((fn sint
    [x]
    (lazy-seq (cons x (sint (inc x))))
  ) start)
)

(defn prime? [x] (or (= x 2) (not (or (= x 1) (some #(= (mod x %) 0) (range 2N (Math/sqrt x)))))))

(defn primes ([] (filter prime? (iterate inc 1N))) ([start] (filter prime? (iterate inc start))))

(defn prime-factors
  [x]
  (filter
    #(== (mod x %) 0)
    (take-while
      #(<= % x)
      (primes))))