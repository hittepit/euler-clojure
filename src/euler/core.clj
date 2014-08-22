(ns euler.core
  (:gen-class))

(require 'euler.solutions)

(defn solve
	[x]
  (def fn-name (str "solve-euler" x))
  (println (str "Solution for problem " x ": " (apply (ns-resolve 'euler.solutions (symbol fn-name)) [])))
)

(defn -main
  [& args]
  (doall (map
  	solve
  	args))
)
