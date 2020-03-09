#lang racket

;	'(1 2 3)
; '(9 -6 4)
; '()
(define (sumofsquares1 lst)
  (foldr
    (λ (elem accumulator) (+ (* elem elem) accumulator))
    0
   lst)
)
; 0 => accumulator
; lst => elem
;If foldl is called with n lists, then proc must take n+1 arguments. 
;The extra argument is the combined return values so far.


;; Repeat with foldl
(define (sumofsquares2 lst)
  (foldl
    (λ (elem accumulator) (+ (* elem elem) accumulator))
    0
   lst)
  )






;; Using foldl, combine a list of strings into a single string,
;; separated by the specified separator.  Separators should only
;; appear between words
(define (join-strings list-of-strings separator)
  (foldl
   (λ (elem accumulator) (string-append accumulator separator elem))
   (first list-of-strings)
   (rest list-of-strings)
  )
)












;; Using foldl, combine a list of strings into a single string,
;; separated by the specified separator.  Separators should only
;; appear between words
(define (join-strings list-of-strings separator)
  (foldl
    (λ (elem accumulator) (string-join accumulator separator elem))
   list-of-strings)
)














;; Make matching open and close tags, using the list of tag-names
(define (make-html-tags tag-names)
  (string-append
   (foldl
    (λ (elem accumulator) (string-append accumulator "<" elem))
   (first tag-names)
   (rest tag-names)
    )
   (foldr
    (λ (elem accumulator) (string-append accumulator "/>" elem))
   (first tag-names)
   (rest tag-names)
    )
    )
)

(make-html-tags '("header" "title"))




