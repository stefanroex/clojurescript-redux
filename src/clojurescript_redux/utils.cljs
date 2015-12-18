(ns clojurescript-redux.utils)

(defn build-containers [[container & children] app-state]
  (when container
    [container app-state (build-containers children app-state)]))
