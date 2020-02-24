#lang racket

(define (make-counter)
    (let ([count 0])
        (λ () 
            (set! count (+ count 1))
            count
        )
    )
)



(define my-count (make-counter)) 
(my-count)
(my-count)
(define ctr2 (make-counter)) 
(ctr2)
(my-count)