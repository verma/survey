(ns survey.core
  (:require [survey.pages :refer [all-pages]]
            [figwheel.client :as fw]
            [sablono.core :as html :refer-macros [html]]
            [om.core :as om :include-macros true]
            [cljs.core.async :as async :refer [<!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(enable-console-print!)


(defn- multi-choice-options [{:keys [options c]} owner]
  (reify
    om/IInitState
    (init-state [_]
      {:items (vec (for [o options]
                     {:text o :selected false}))})

    om/IRenderState
    (render-state [_ {:keys [items]}]
      (let [opts (mapv
                  (fn [item index]
                    [:a.option {:class (when (:selected item) "selected")
                                :href "javascript:"
                                :on-click (fn []
                                            (println "clicked!")
                                            (om/update-state! owner [:items index :selected] not))} (:text item)])
                  items (range))
            last-item [:a.option.move-on {:href "javascript:"
                                          :on-click (fn []
                                                      (async/put! c (->> items
                                                                         (filter :selected)
                                                                         (mapv :text))))} "Move on"]
            all-items (vec (concat [:div.options.multiple]
                                   [[:h4 (when (seq options) "Select all that apply")]]
                                   opts [last-item]))]
        (html all-items)))))

(defn- single-choice-options [{:keys [options c]} owner]
  (om/component
   (html
    [:div.options.single 
     [:h4 "Select one"]
     (for [o options]
       (let [nm (str (gensym))]
         [:a.option {:href "javascript:"
                     :on-click #(async/put! c o)} o]))])))

(defn- page [{:keys [c key title content multi-choice single-choice]}]
  [:div.page {:class key}
   [:h1 title]
   [:div.content (if (ifn? content) (content) content)]
   (when multi-choice
     (om/build multi-choice-options {:options multi-choice :c c} {:react-key (name key)}))
   (when single-choice
     (om/build single-choice-options {:options single-choice :c c} {:react-key (name key)}))])



(defn- main [app-state owner]
  (reify
    om/IInitState
    (init-state [_]
      {:slide-index 0
       :responses []
       :c (async/chan)})

    om/IDidMount
    (did-mount [_]
      (let [c (om/get-state owner :c)]
        (go-loop [res (<! c)]
                 (println res)
                 (om/update-state! owner :slide-index inc)
                 (om/update-state! owner :responses #(conj % res))
                 (recur (<! c)))))

    om/IRenderState
    (render-state [_ {:keys [slide-index c]}]
      (let [p (nth app-state slide-index)
            p (assoc p :c c)]
        (html (page p))))))

(om/root main [(nth all-pages 14)] {:target (. js/document getElementById "main-area")})

(println all-pages)

(fw/start {
  :on-jsload (fn []
               ;; (stop-and-start-my app)
               )})
