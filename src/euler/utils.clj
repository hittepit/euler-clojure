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

(defn prime? [x] (or (= x 2) (not (or (= x 1) (some #(= (mod x %) 0) (range 2N (+ 1 (Math/sqrt x))))))))

(defn primes ([] (filter prime? (iterate inc' 1))) ([start] (filter prime? (iterate inc' start))))

(defn prime-factors
  [x]
  (filter
    #(== (mod x %) 0)
    (take-while
      #(<= % x)
      (primes))))

(defn prime-factors-all
  [x]
  (loop
    [a x acc []]
    (if (== a 1)
      (reverse acc)
      (let [f (first (prime-factors a))]
        (recur (/ a f) (cons f acc))
      )
    )
  )
)

(defn gcd
  [x y]
  (loop
    [a x b y]
    (if (= b 0)
      a
      (recur b (mod a b))
    )
  )
)

(defn gcm
  [x y]
  (/ (*' x y) (gcd x y)))

;(map (fn [x] (count (filter #(= % x) a))) (set a))

(defn palindrome?
  [s]
  (= (seq (str s)) (reverse (str s))))