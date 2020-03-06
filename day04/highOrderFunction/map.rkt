#lang racket

(define (add-one x)
    (+ x 1)
)

(add-one 1)

(map add-one '(1 2 3))

(displayln "")
(displayln "---------ex2-------- ")



(define lst '(1 2 3 4 5))
(map number->string lst)

(map (λ (x) (* x x)) lst)

(map number->string
    (map (λ (x) (expt 2 x))  ; expt -> exponent指数
)
