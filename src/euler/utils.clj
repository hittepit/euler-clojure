(ns euler.utils)

(require '[clojure.java.io :as io])

(use '[clojure.core.match :only (match)])

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

(def naturals
  ((fn int-seq
    [x]
    (lazy-seq (cons x (int-seq (inc' x))))
  ) 0)
)

(defn 
  ^{:doc "Returns true is argument is a prime number, false otherwise"}
  prime? 
  [x] 
  (or (= x 2) (not (or (= x 0) (= x 1) (some #(= (mod x %) 0) (range 2 (+ 1 (Math/sqrt x))))))))

(def primes
  (filter
     prime?
     naturals))

(defn prime-factors
  [x]
  (filter
    #(== (mod x %) 0)
    (take-while
      #(<= % x)
      primes)))

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

(defn collazt-next
  [x]
  (if
    (even? x)
    (/ x 2)
    (+ 1 (* 3 x))))

(defn collatz-seq
  [start]
  (cons 
    start
    (if
      (= start 1)
      nil
      (collatz-seq (collazt-next start)))))

(defn collatz-count
  [start]
  (loop
    [total 0 el start ]
    (if
      (= el 1)
      (+ total 1)
      (recur (+ total 1) (collazt-next el)))))

(defn reconstitue
  [coll]
  (match [coll]
    [([] :seq)] nil
    [([a & r] :seq)] (cons a (reconstitue r))))

(defn my-map
  [f coll]
  (loop [cs coll acc nil]
    (if (= 0 (count cs))
      (reverse acc)
      (recur 
        (rest cs) 
        (cons 
          (f 
            (first cs)) 
          acc)))))