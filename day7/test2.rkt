#lang racket

(define x 2)

(
    {lambda (y)
        (
            {lambda (z)
                (+ x y z)} 
            4
        )
    }
3)