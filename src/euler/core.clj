(ns euler.core
  (:gen-class))

(require 'euler.solutions1)
(require 'euler.solutions2)

(defn solve
	[x]
  (def solution-number (Integer/parseInt x))
  (def namespace-name (str "euler.solutions" (+ (quot solution-number 10) 1)))
  (def fn-name (str "solve-euler" x))
  (println (str "Solution for problem " x ": " (apply (ns-resolve (symbol namespace-name) (symbol fn-name)) [])))
)

(defn -main
  [& args]
  (doall (map
  	solve
  	args))
)
