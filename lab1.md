## max-num
```scheme
#lang racket
(define (max-num lst)
    (cond [(empty? lst) (error "empty")]
          [(= (length lst) 1) (car lst)]
          [else {let ([max-tail (max-num (cdr lst))]
                      [x (car lst)]  )
                 (if (> x max-tail)
                      x
                      max-tail)
          }]
    )
)

(max-num `(1 2 3 4))
```
---

## max-num
```scheme
#lang racket
(provide max-num fizzbuzz)

(define (max-num lst)
  ;; YOUR CODE HERE -- call `error` on an empty list
   (cond [(null? lst) (error "current list is empty")]
         [(= 1 (length lst)) (car lst)] ;if only one element in list, return index 0
         ;else statement, call recursion
         [else 
           (if (< (car lst) (max-num (cdr lst)))
                     (max-num (cdr lst))
                     (car lst)
           )
         ]
   )
)
;;(max-num '(1 2 3 4))
```










## fizzbuzz

```scheme
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
```
---

## my ans
```scheme
#lang racket

;; The function counts from 1 to the specified number, printing a string with the result.
;; The rules are:
;;    If a number is divisible by 3 and by 5, instead say "fizzbuzz"
;;    Else if a number is divisible by 3, instead say "fizz"
;;    Else if a number is divisible by 5, instead say "buzz"
;;    Otherwise say the number
;;
(define (helper x)
    (cond [(= (modulo x 15) 0) "fizzbuzz"]
          [(= (modulo x 3) 0) "fizz"]
          [(= (modulo x 5) 0) "buzz"]
          [else (number->string x)]
    )
)
;("1" "2" "fizz" "4" "buzz" "fizz" "7" "8" "fizz")
; my output is really close to the answer, I have tried my best...
;I just need to remove ( ), but I don't know how to do it...
(define (fizzbuzz n)
   (if (< n 1)
      ""
      ;(append (fizzbuzz (- n 1)) (list (helper n)))
      (string-append (fizzbuzz (- n 1)) 
                     (helper n)
                     " "
      )
   )
 )

(fizzbuzz 100)
```
