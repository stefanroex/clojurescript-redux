(ns clojurescript-redux.components
  (:require [clojurescript-redux.routes :as routes]))

(defn link-to [router handler name]
  (let [active? (= handler (:handler router))
        class (if active? "active")]
    [:a {:class class :href (routes/path-for handler)} name]))

(defn counter [{:keys [:handle-inc-counter :handle-dec-counter :counter]}]
  [:div
   [:div (:count counter)]
   [:button {:on-click #(handle-dec-counter (:id counter))} "-"]
   [:button {:on-click #(handle-inc-counter (:id counter))} "+"]])

(defn counters [props]
  [:div
   [:div.btn.btn--primary {:on-click (:handle-add-counter props)} "Add counter"]
   [:div.btn {:on-click (:handle-pop-counter props)} "Remove counter"]
   [:h2 (:total props)]
   (for [c (:counters props)]
     ^{:key (:id c)}
     [counter (-> (select-keys props [:handle-inc-counter
                                      :handle-dec-counter])
                  (assoc :counter c))])])
