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

