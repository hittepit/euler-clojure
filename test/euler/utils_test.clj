(ns euler.utils-test
	(:require [clojure.test :refer :all]
            [euler.utils :as utils :refer :all]))

(deftest fibo-seq-test
	(testing "First numbers of fibonacci"
		(is (= '(0 1 1 2 3 5 8 13 21 34 55) (take 11 utils/fibo-seq))))
)

(deftest triangle-numbers-seq-test
	(testing "5 first triangle numbers"
		(is (= '(1 3 6 10 15) (take 5 utils/triangle-numbers-seq))))
)

(deftest prime-test
	(testing "7 is prime"
		(is (true? (utils/prime? 7))))
	(testing "49 is not prime"
		(is (false? (utils/prime? 49))))
	(testing "1 is not prime"
		(is (false? (utils/prime? 1))))
	(testing "2 is prime"
		(is (true? (utils/prime? 2))))
)

(deftest primes-test
	(testing "10 first primes sequence"
		(is (= '(2 3 5 7 11 13 17 19 23 29) (take 10 (utils/primes)))))
)

(deftest palindrome-test
	(testing "123321 is a palindrome"
		(is (true? (utils/palindrome? 123321))))
	(testing "1 is a palindrome"
		(is (true? (utils/palindrome? 1))))
	(testing "123322 is not a palindrome"
		(is (false? (utils/palindrome? "123322"))))
)

(deftest prime-factors-all-test
	(testing "18 -> 2 3 3"
		(is (= '(2 3 3) (utils/prime-factors-all 18))))
	(testing "1 -> no prime factors"
		(is (= '() (utils/prime-factors-all 1))))
	(testing "17 -> 17"
		(is (= '(17) (utils/prime-factors-all 17))))
)

(deftest gcd-test
	(testing "gcd of 18 27 = 9"
		(is (= 9 (utils/gcd 18 27))))
	(testing "gcd of 17 and 23 is 1"
		(is (= 1 (utils/gcd 17 23))))
)

(deftest gcm-test
	(testing "gcm of 18 27 is 54"
		(is (= 54 (utils/gcm 18 27)))))

(deftest factors-test 
	(testing "factors of 12"
		(is (= #{1 2 3 4 6 12} (utils/factors 12))))
	(testing "factors of 1"
		(is (= #{1} (utils/factors 1))))
	(testing "factors of 17"
		(is (= #{1 17} (utils/factors 17))))
)

(deftest collatz-seq-test
	(testing "sequence for 13"
		(is (= '(13 40 20 10 5 16 8 4 2 1) (utils/collatz-seq 13))))
	(testing "sequence for 1"
		(is (= '(1) (utils/collatz-seq 1))))
)

(deftest collatz-count-test
	(testing "count for 1 is 1"
		(is (= 1 (collatz-count 1))))
	(testing "count for 13 is 10"
		(is (= 10 (collatz-count 13))))
)