(ns clojurescript-redux.actions)

(defn add-counter []
  {:type :add-counter})

(defn pop-counter []
  {:type :pop-counter})

(defn inc-counter [id]
  {:type :inc-counter
   :id id})

(defn dec-counter [id]
  {:type :dec-counter
   :id id})

(defn update-route [payload]
  {:type :update-route
   :payload payload})
