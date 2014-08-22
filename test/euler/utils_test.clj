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