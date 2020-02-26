#lang racket

(define (swap x y)
    (let ([tmp x])
        (set! x y)
        (set! y tmp)
    )
)

(let ([a 7] [b 3])
    (swap a b)
    (displayln a)
    (displayln b)
)


;
;
; set! example:
(displayln "")
(displayln "another example:")

(define x 3)

(define (foo)
  (define x 4)
  x)

(define (bar)
  (set! x 4)
  x)

(foo) ; returns 4
x     ; still 3
(bar) ; returns 4
x     ; is now 4