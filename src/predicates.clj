(ns predicates)


(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))


(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))


(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))


(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))


(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [s]
  (let [is-empty (fn [s] (or (empty? s) (nil? s)))]
    (or (is-empty s))
    (every? whitespace? s)))


(defn has-award? [book award]
  (contains? (:awards book) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))


(defn my-some [pred a-set]
  (first (filter identity (map pred a-set))))


(defn my-every? [pred a-set]
  (= (count a-set) (count (filter pred a-set))))


(defn prime? [n]
  (empty? (filter (fn [k] (= 0 (mod n k))) (range 2 n))))

;^^
