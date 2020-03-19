#lang racket

(define x 2)

{let ([y 3])
    {let ([z 4])
        (+ x y z) 
    }
}