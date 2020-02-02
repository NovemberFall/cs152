#lang racket
(define/contract (square x)
(-> number? number?)
(* x x))

(square 4)
(square "four")