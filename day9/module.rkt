#lang racket

(define (less-than-piovt pivot)
    (λ (lst)
        (empty? (filter (λ (x) (> x pivot))))
    )
)

(define (list-of-nums? lst)
    (filter ((λ (x) (not (number? x))) lst))
)
(define (partition lst pivot left right)
    (-> list? number? list? list? pair?)
    ;(cons left right)
    (if (empty? lst)
        (cons left right)
        (let [x (car lst)]
             [rest (cdr lst)]
        )
        (if (> x pivot)
            (partition rest pivot (cons x left) right)
            (partition rest pivot  left (cons x right))
        )
    )
)
(define/contract (quicksort lst)
    (-> list? list?)
    (if (empty? lst)
        '()
        (let* ([pivot (car lst)]
              [p (partition (cdr lst) pivot '() '())]
              [left (quicksort (car p))]
              [right (quicksort (cdr p))]
             )
             (cons pivot (append left right))
        )
    )
)

(quicksort '())