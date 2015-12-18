(ns clojurescript-redux.routes
  (:require [goog.events :as events]
            [clojurescript-redux.actions :as actions]
            [bidi.bidi :as bidi]
            [goog.history.EventType :as EventType])
  (:import goog.History))

(def routes ["/" {"" :counters
                  "route-a" {"" :route-a
                             "/subpage" :subroute-a}
                  "route-b" :route-b}])

(defn match-route [token]
  (if (= token "")
    {:handler :counters}
    (bidi/match-route routes token)))

(defn path-for [path]
  (str "#" (bidi/path-for routes path)))

(defn hook-routes [dispatch]
  (let [h (History.)
        handler #(dispatch (actions/update-route (match-route (.-token %))))]
    (goog.events/listen h EventType/NAVIGATE handler)
    (doto h (.setEnabled true))))
