(ns pictograph.controllers.home
  (:use caribou.app.controller)
  (:require [caribou.model :as model]))

(defn home
  [request]
  (render request))

(defn presentation
  [request]
  (let [title (-> request :params :title)
        presentation (model/pick
                      :presentation
                      {:where {:title title}
                       :include {:slides {}}})]
    (render (assoc request
              :presentation presentation))))

(defn slide
  [request]
  (let [slide-title (-> request :params :slide)
        slide     (model/pick
                   :slide
                   {:where {:title slide-title}
                    :include {:presentation {}}})
        following (model/following
                   :slide slide
                   :presentation_position
                   {:where (select-keys slide [:presentation_id])})
        previous  (model/previous
                   :slide slide
                   :presentation_position
                   {:where (select-keys slide [:presentation_id])})]
    (render (assoc request
              :slide slide
              :following following
              :previous previous))))