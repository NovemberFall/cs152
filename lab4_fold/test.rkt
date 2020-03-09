#lang racket

;; Using foldl, combine a list of strings into a single string,
;; separated by the specified separator.  Separators should only
;; appear between words
(define (join-strings list-of-strings separator)
  (foldl
   (λ (elem accumulator)
     (if (eq? accumulator "")
         elem
         (string-append accumulator separator elem))
   )
   ""
   list-of-strings)
)





;; Make matching open and close tags, using the list of tag-names
(define (make-html-tags tag-names)
  (string-append
   (foldl
    (λ (tag rest)
      (string-append rest "<" tag ">"))
    ""
    tag-names)
   (foldr
    (λ (tag rest)
      (string-append
       rest "</"
       tag
       ">"
      )
    )
    ""
    tag-names))
)








