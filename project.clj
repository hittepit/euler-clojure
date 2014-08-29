(defproject euler "0.1.0-SNAPSHOT"
  :description "Solutions for Euler project"
  :url "https://projecteuler.net/about"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"] [org.clojure/core.match "0.2.1"]]
  :main ^:skip-aot euler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
