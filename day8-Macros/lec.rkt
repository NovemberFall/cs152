#lang racket

(define (Employee name position salary)
    (list (box name) (box position) (box salary) )
)

(define (get-name emp)
    ((caar emp))
)

(define (set-name emp re-name)
    ((cdr emp) re-name)
)