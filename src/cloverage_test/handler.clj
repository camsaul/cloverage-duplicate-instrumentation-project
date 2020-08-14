(ns cloverage-test.handler
  (:require [cloverage-test.handler.middleware :as middleware]))

(def middleware
  [#'middleware/my-middleware])

(def handler
  (reduce
   (fn [handler middleware]
     (middleware handler))
   identity
   middleware))
