#lang racket

(provide strings-to-nums make-names employees managers-only)

(define (strings-to-nums lst)
   (map string->number lst)
  )

;; In racket, we can apply `map` to multiple lists,
;; (although this is not true in all functional langauges).
;; For example, `list-of-sums` is '(5 7 9).
(define list-of-sums (map + '(1 2 3) '(4 5 6)))

;; Write a function that takes a list of list of first names
;; and a list of last names and produces a list of full names.
;; You may assume that the lists are of equal length.
(define (make-names fnames lnames)
   (map 
      (λ (firstName lastName) (string-append firstName " " lastName)) 
        fnames lnames)
      ;writing a function, map ((f l)=> (f + " " + l)) => (fnames, lnames)
  )

;; Write a function that takes a list of employees (each represented as a list)
;; and return a list of managers.
(define employees
  '( ("Robert" "Tables" 100000 "Manager")
     ("Alice" "Liddell" 50000 "Copy editor")
     ("Tweedle" "Dee" 46000 "entry level")
     ("Tweedle" "Dum" 46000 "entry level")
     ("William" "Gates" 100000000000 "Manager")
     ("Marcus" "Aurelius" 0 "Manager")))

(define (managers-only lst)
    (filter 
        (λ (requiredElem) 
            (cond [(eq? (list-ref requiredElem 3) "Manager") #t]
                  [else #f]
            )  
        )
        lst
    )
  )