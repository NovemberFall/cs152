#lang racket

;; Make matching open and close tags, using the list of tag-names
(define (make-html-tags tag-names)
  (string-append
   (foldl
    (λ (elem accumulator) (string-append accumulator "<" elem ">"))
   (first tag-names)
   (rest tag-names)
    )
   (foldr
    (λ (elem accumulator) (string-append accumulator "<" elem "/>"))
   (first tag-names)
   (rest tag-names)
    )
    )
)

(make-html-tags '("header" "title"))