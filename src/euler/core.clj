(ns euler.core
  (:gen-class))

(require 'euler.solutions)

(defn solve
	[x]
  (def fn-name (str "solve-euler" x))
  (println (apply (ns-resolve 'euler.solutions (symbol fn-name)) []))
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (solve (first args))
)
