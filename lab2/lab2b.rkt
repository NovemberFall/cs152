#lang racket

(define (reverse lst)
    (if (null? lst)
        '()     ;if list is empty, the revers list is still empty
        (append (reverse (cdr lst))
                (list (car lst))
        )
        ; '(1 2 3 4)
        ; '(2 3 4)   
        ; '(3 4)
        ; '(4)
        ; list (car lst) => '(4)
        ; list (car lst) => '(4 3)
        ; list (car lst) => '(4 3 2)
        ; list (car lst) => '(4 3 2 1)
    )
)
(reverse `(1 2 3 4))