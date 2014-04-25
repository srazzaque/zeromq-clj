(defproject io.cronic/zeromq-clj "0.1.3-SNAPSHOT"
  :description "Clojure-friendly access to ZeroMQ (using the JeroMQ implementation)"
  :url "http://cronic.io/zeromq-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.zeromq/jeromq "0.3.2"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]])
