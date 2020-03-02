#| #lang racket

(provide (contract-out  [amount (and/c number? positive?)])
)

(define amount 2)
 |#







#lang racket
 
(provide (contract-out
          [deposit (-> number? any)]
          [balance (-> number?)]))
 
(define amount 0)
(define (deposit a) (set! amount (+ amount a)))
(define (balance) amount)

(deposit 5)
(displayln amount)















