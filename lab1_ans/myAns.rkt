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