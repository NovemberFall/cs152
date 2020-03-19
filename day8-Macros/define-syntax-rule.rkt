#lang racket

(define-syntax-rule (swap x y)
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



(displayln "")
(displayln "Correct version of my-if")

(define-syntax-rule
    (my-if c thn els)
        (cond
            [(and (list? c) (empty? c)) els]
            [(and (number? c) (= 0 c)) els]
            [(and (boolean? c) (not c)) els]
            [else thn]
        )
)