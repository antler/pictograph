(defproject pictograph-site "0.1.0"
  :description "The page routing ring handler for caribou"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [antler/caribou-admin "0.9.12"]
                 [swank-clojure "1.4.2"]]
  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n"]
  :source-paths ["src" "../src"]
  :resource-paths ["resources/" "../resources/"]
  :ring {:handler pictograph.core/handler
         :servlet-name "pictograph-frontend"
         :init pictograph.core/init
         :port 33333})
