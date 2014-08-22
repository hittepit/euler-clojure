(ns euler.utils-test
	(:require [clojure.test :refer :all]
            [euler.utils :as utils :refer :all]))

(deftest prime-test
	(testing "7 is prime"
		(is (true? (utils/prime? 7))))
	(testing "49 is not primer"
		(is (false? (utils/prime? 49))))
	(testing "1 is not prime"
		(is (false? (utils/prime? 1))))
	(testing "2 is primer"
		(is (true? (utils/prime? 2))))
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