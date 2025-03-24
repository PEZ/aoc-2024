(ns aoc.util
  (:require
   [clj-http.client :as http]))

(defn- fetch-as-authed [path]
    (let [session (slurp ".aoc-session")]
      (-> (http/get (str "https://adventofcode.com" path)
                    {:cookies {"session" {:value session}}})
                                                     :body)))

(defn- fetch-puzzle [year day]
  (fetch-as-authed (str "/" year "/day/" day)))

(defn- fetch-input' [year day]
  (fetch-as-authed (str "/" year "/day/" day "/input")))

(def fetch-input
  (memoize fetch-input'))

(comment
  (fetch-puzzle 2024 1)
  (fetch-input' 2024 1)
  (fetch-input 2024 1)
  :rcf)

(defn transpose [c]
  (apply mapv vector c))

(defn collection-distance [a b]
  (map (comp abs -) a b))



