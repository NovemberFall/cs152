#lang racket

(provide (contract-out  [amount positive?])
)

(define amount 0)