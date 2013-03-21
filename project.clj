(defproject pictograph "0.9.6"
  :description
  "caribou development: The prototypical caribou project"

  :dependencies
  [[org.clojure/clojure "1.4.0"]
   [antler/caribou-core "0.9.9"]]

  :migration-namespace "pictograph.migrations"

  :sub
   ["api"
    "site"]

  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n"])
