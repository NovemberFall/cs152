#lang racket
; reverse
(define (reverse lst)
    (if (empty? lst))
        lst
        (append (reverse(cdr lst))
            (list (car lst)) )
)

(reverse '(1 2 3 4))







;part b
(define (add-two-lists lst1 lst2)
    (cond [(empty? lst1) lst2]
          [(empty? lst2) lst1]
          [else (cons (+ (car lst1) (car lst2)))
                (add-two-lists (cdr lst1) (cdr lst2))
          ]

    )
)







;part c
(define (pno lst)
    (cond [(empty? lst) lst]
          [(positive? (car lst))
            (cons (car lst)
                  (pno (cdr lst))
                  )]
          [else (pno (cdr lst))]
    )
)