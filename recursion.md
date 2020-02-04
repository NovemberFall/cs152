## example:
```scheme
#lang racket
;example:
(define (count-elems lst)
    (cond [(= 0 (length lst)) 0]
        [else 
            (+ 1 (count-elems(cdr lst)))
        ]
    )
)

(count-elems '())
(count-elems '(1 2 3 4 5))

=> 0
=> 5





```






```scheme
```





```scheme
```








