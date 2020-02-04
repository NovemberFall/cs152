#lang racket
(define (fizzbuzz n)
    (if (<= n 0)
        (error "n must be positive")
        (fb 1 n))
)


(define (fb i n)
    (string-append 
        (cond [(and (divisible? i 3)
                    (divisible? i 5)) "fizzbuzz"]
              [(divisible? i 3) "fizz"] 
              [(divisible? i 5) "buzz"]      
              [else (number->string i)])
        " "
        (if (= i n)  ""   (fb (+ i 1) n))
    )
)

(define (divisible? i n)
        ;(= 0 (modulo i n))
        (integer? (/ i n))
)

(fizzbuzz 100)