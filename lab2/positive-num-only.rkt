
(define (helper lst temp)
    (if (= (length lst) 0)
        temp ;if my list is empty, just return null
        (if (> (car lst) 0) ; if my list's first elment is > 0
            (helper (cdr lst) 
                (append temp (list (car lst)))
            )
            (helper (cdr lst) temp)
        )
    )
)

(define (positive-nums-only lst)
        (helper lst '())
)