(ns cloverage-test.handler.middleware
  (:require [clojure
             [pprint :as pprint]
             [string :as str]]))

(println "[Loading cloverage-test.handler.middleware]")

(let [covered (some-> (resolve 'cloverage.coverage/*covered*) deref deref)]
  (printf "cloverage.coverage/*covered*: bound? %s identity hash code: %s\n"
          (some? covered)
          (some-> covered System/identityHashCode)))

(println "Stacktrace:")

(pprint/pprint (filter #(str/starts-with? % "cloverage.")
                       (map str (.getStackTrace (Thread/currentThread)))))

(defn my-middleware [handler]
  (fn [query]
    (handler (assoc query :middleware? true))))
