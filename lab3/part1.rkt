#lang racket

(define (strings-to-nums lst)
    (map string->number lst)
  )




(define (make-names fnames lnames)
   (map 
      (λ (firstName lastName) (string-append firstName " " lastName)) 
        fnames lnames)
)



(define (managers-only lst)
    (filter 
        (λ (requiredElem) 
            (cond [(eq? (list-ref requiredElem 3) "Manager") #t]
                  [else #f]
            )  
        )
        lst
    )
  )