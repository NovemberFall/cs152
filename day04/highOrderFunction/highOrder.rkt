(define (add-one-to-each-elem lst)
    (cond [(empty? lst)  '()]
          [else (cons (+ (car lst) 1)
                (add-one-to-each-elem (cdr lst))
          )]
    )
)

(define (subtract-two-from-each-elem lst)
    (cond [empty? lst '()]
        [else (cons
            (- (car lst) 2) 
            (subtract-two-from-each-elem (cdr lst))
        )]
    )
)


(define (do-to-each-elem fn lst)
    (cond [(empty? lst) lst]
        [else (cons (fn (car lst))
            (do-to-each-elem (cdr lst))
        )]
    )
)



(define (add-one-to-each-elem lst)
    (map (λ (x) (+ x 1)) lst)
)

(define (subtract-two-from-each-elem lst)
    (map (λ (x) (- x 2)) lst)
)


(define (pos-nums-only lst)
    (cond [(empty? lst) list]

    )
)

;change extract-elems to filter
(define (filter pred lst)
    (cond [(empty? lst) lst]
        [(pred (car lst))
            (cons (car lst)
                    (filter pred (cdr lst))
        )]
        [(filter pred (cdr lst))]
    )
)