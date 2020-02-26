#lang racket

(define (my-if c thn els)
    (cond [(and (list? c) (empty? c)) els])

)