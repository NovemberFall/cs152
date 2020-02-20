##
- big-num.rkt
```scheme
(define/contract (big-add1 x y co)
  (-> bignum? bignum? zero-or-one? bignum?)
  (cond
    ;; If both lists are empty, the return value is either 0 or the caryover value.
    [(and (= 0 (length x)) (= 0 (length y)))
      (if (= co 0) '() (list co))]
    [(= 0 (length x))  (big-add1 (list co) y 0)]
    [(= 0 (length y))  (big-add1 x (list co) 0)]
    [else
       (if (>= 999 (+ (car x) (car y) co))
           (append (list (+ (car x) (car y) co))
                 (big-add1 (cdr x) (cdr y) 0)
           )
           (append (list (- (+ (car x) (car y) co) 1000))
                 (big-add1 (cdr x) (cdr y) 1)
           )
       )
     ]
    ))
```

```scheme
;; NOTE: there are no negative numbers with this implementation,
;; so 3 - 4 should throw an error.
(define/contract (big-subtract1 x y borrow)
  (-> bignum? bignum? zero-or-one? bignum?)
   (cond [(and (= 0 (length x)) (= 0 (length y))) '()]
         [(= 0 (length y)) (list (- (car x) borrow))]
         [else (if (< (car x) (car y))
                   (append (list (- (+ 1000 (car x)) (car y) borrow))
                           (big-subtract1 (cdr x) (cdr y) 1)
                   )
                   (append (list (- (car x) (car y) borrow))
                           (big-subtract1 (cdr x) (cdr y) 0)
                   )
               )
         ]
    )
  )
```