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













{let ([dilbert (employee "Dilbert" "Adams" 80000)]
      [aice (employee "Alice" "Rage" 95000)]
      [phb (manager "PoirtyHaired" "Boss" 105000 200000)])
    (displayln (calc-wages dilbert))
    (displayln (calc-wages alice))
    (displayln (calc-wages phb))
}