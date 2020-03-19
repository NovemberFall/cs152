#lang racket

(define-syntax switch
    (syntax-rules ()
        ; if the value match, we call the function to print expression
        [(switch x [val expression]) expression]
        ; if we don't find the value, call the [pattern template]
        [(switch x [val expression] rest ...)
            (if (equal? x val)
                expression
                (switch x rest ...)
            )
        ]
    )
)


(define x 3)
(switch x
    [3 (displayln "x is 3")]
    [4 (displayln "x is 4")]
    [5 (displayln "x is 5")]
    [default (displayln "none of the above")]
)


(define (is-even? n)
   (switch (modulo n 2)
      [0 #t]
      [1 #f]))
(is-even? 9)
(is-even? 8)
