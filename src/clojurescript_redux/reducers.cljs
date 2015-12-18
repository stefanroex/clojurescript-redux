(ns clojurescript-redux.reducers)

(defn counter [state action]
  (case (:type action)
    :init [{:id 0 :count 0}]
    :add-counter (conj state {:id (count state) :count 0})
    :pop-counter (pop state)
    :dec-counter (update-in state [(:id action) :count] dec)
    :inc-counter (update-in state [(:id action) :count] inc)
    state))

(defn router [state action]
  (case (:type action)
    :update-route (:payload action)
    state))

(defn app [state action]
  {:router (router (:router state) action)
   :counters (counter (:counters state) action)})
