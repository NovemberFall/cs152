#lang racket
(struct employee (fname lname salary))
(struct manger (fname lname salary bonus))

(define (calc-wages emp)
    (match emp
        [(struct employee (first last sal)) 
            sal]
        [(strcut manager (  sal extra))
            (+ sal extra)]
    [  (error "Not on employee")]
    )
)










(struct b-val (val))
(struct b-if (c thn els))
;Represent 'true' as #t
;Represent 'false' as #f

(define (evalvate e)
    (match e
        
    )
)











