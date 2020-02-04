#lang racket
(define (max-num lst)
    (cond [(empty? lst) (error "empty")]
          [(= (length lst) 1) (car lst)]
          [else {let ([max-tail (max-num (cdr lst))]
                      [x (car lst)]  )
                 (if (> x max-tail)
                      x
                      max-tail)
          }]
    )
)

(max-num `(1 2 3 4))