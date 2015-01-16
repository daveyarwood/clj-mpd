(ns clj-mpd.test.core
  (:use [clj-mpd.core])
  (:use [clojure.test]))

; these tests rely on there being an MPD instance running on localhost:6600

(deftest mpd-instance-tests
  (with-mpd-connection :default
    (testing "attributes"
      (is (re-matches #"MPD [\d\w\.\-]+" (get-version)))
      (is (= "localhost" (.getHostName (get-address))))
      (is (= 6600 (get-port)))
      (is (= 0 (get-timeout))))))
