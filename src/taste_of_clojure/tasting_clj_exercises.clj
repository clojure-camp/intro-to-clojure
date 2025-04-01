;; A Taste of Clojure - Intro Mob Programming Exercises
;; Repo designed for a 2-hour beginner Clojure session with Calva + REPL
(ns taste-of-clojure.tasting-clj-exercises)
 

;; -----------------------------------------------------------------------------
;; 🟢 REPL Warmup
;; -----------------------------------------------------------------------------

;; Evaluate these one by one in the REPL:
(+ 1 2)
(* 3 4)
(str "Hello, " "world!")

;; Define and call a simple function:
(defn greet [name]
  (str "Hi " name "!"))

(greet "Jordan")


;; -----------------------------------------------------------------------------
;; 🟡 Data Manipulation
;; -----------------------------------------------------------------------------

(def people
  [{:name "Alex" :age 31}
   {:name "Taylor" :age 24}
   {:name "Jordan" :age 38}])

;; Extract names
(map :name people)

;; Filter people older than 30
(filter #(> (:age %) 30) people)

;; Sum of all ages
(reduce + (map :age people))


;; -----------------------------------------------------------------------------
;; 🔵 Build a Small Program: TODO Tracker
;; -----------------------------------------------------------------------------

(def todos [])

(defn add-todo [todos item]
  (conj todos {:task item :done false}))

(defn mark-done [todos index]
  (assoc-in todos [index :done] true))

(defn show-todos [todos]
  (map-indexed (fn [i {:keys [task done]}]
                 (str i ". [" (if done "x" " ") "] " task))
               todos))

;; Try it out in the REPL:
;; (def todos1 (add-todo todos "Feed cat"))
;; (def todos2 (add-todo todos1 "Wash dishes"))
;; (def todos3 (mark-done todos2 0))
;; (show-todos todos3)


;; -----------------------------------------------------------------------------
;; 🟣 Extra Credit: Map of Lists
;; -----------------------------------------------------------------------------

(def shopping-list
  {:fruits ["apple" "banana"]
   :veggies ["carrot" "spinach"]})

;; Add an item to a category
(defn add-item [list category item]
  (update list category conj item))

;; Example:
;; (add-item shopping-list :fruits "mango")

