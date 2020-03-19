#lang racket
(define (my-if c thn els)
    (cond
        [(and (list? c) (empty? c)) els]
        [(and (number? c) (= 0 c)) els]
        [(and (boolean? c) (not c)) els]
        [else thn]
    )
)


(my-if #t 1 0) ;; returns 1
(my-if 1 1 0) ;; also returns 1
(my-if #f 1 0) ;; returns 0
(my-if '() 1 0) ;; also returns 0, since (list? '()) => true,   (empty? '()) => true

(my-if #t
    (displayln "true")
    (displayln "false")
)
