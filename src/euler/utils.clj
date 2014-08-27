(ns euler.utils)

(require '[clojure.java.io :as io])

(defmacro find-first
  [condition collection]
  (list
    'first
    (list
      'filter
      condition
      collection
      )))

(def fibo-seq 
  (
  	(fn fib 
  		[a b] 
  		(lazy-seq 
  			(cons 
  				a 
  				(fib b (+ a b))))
  	)	0 1)
)

(def triangle-numbers-seq
  (
    (fn rtriangle
      [x]
      (lazy-seq 
        (cons 
          (reduce + (range 1 (+ 1 x)))
          (rtriangle (inc x))
        )
      )
    ) 1)
)

(def int-seq
  ((fn sint
    [x]
    (lazy-seq (cons x (sint (inc x))))
  ) 0)
)

(defn 
  ^{:doc "Returns true is argument is a prime number, false otherwise"}
  prime? 
  [x] 
  (or (= x 2) (not (or (= x 1) (some #(= (mod x %) 0) (range 2 (+ 1 (Math/sqrt x))))))))

(defn primes
  []
  ((fn
    [start]
    (filter
      prime?
      (iterate inc' start))) 1))

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

(defn 
  ^{:doc "Returns all positive integer factors of the argument"}
  factors
  [x]
  (apply sorted-set
    (reduce
      (fn [acc i]
        (if
          (= (mod x i) 0)
          (conj (conj acc i) (/ x i))
          acc))
      #{}
      (range 1 (+ 1 (Math/sqrt x))))))

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

(defn palindrome?
  [s]
  (= (seq (str s)) (reverse (str s))))

(defn readFile
  [n]
  (let [rdr (io/reader (clojure.java.io/resource n))]
    (line-seq rdr)))