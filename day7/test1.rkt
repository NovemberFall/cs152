#lang racket

(define x 2)

{let ([y 3])
   ({λ (z)
        (+ x y z)
        }
    4)
}