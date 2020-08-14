(ns cloverage-test.core-test
  (:require [clojure.test :refer :all]
            [cloverage-test.a :as a]))

(deftest process-request-test
  (is (= {:request? true, :middleware? true}
         (a/process-request {}))))
