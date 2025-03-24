(ns aoc-2024.day-1
  (:require [aoc.util :as util]))

(def input
  "3   4
4   3
2   5
1   3
3   9
3   3"
  #_(util/fetch-input 2024 1))

(defn- parse-input [s]
  (->> s
       (re-seq #"\w+")
       (map parse-long)
       (partition 2)
       util/transpose))

;; part 1
(comment
  (->> input
       parse-input
       (map sort)
       (apply util/collection-distance)
       (apply +))
  )

;; part 2
(comment
  (let [[a b] (parse-input input)
        count-ids (frequencies b)]

    (->> a
         (map #(count-ids % 0))
         (map * a)
         (apply +))))



