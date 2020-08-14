(ns cloverage-test.a
  (:require [cloverage-test.handler :as handler]))

(defn process-request [m]
  (handler/handler (assoc m :request? true)))
