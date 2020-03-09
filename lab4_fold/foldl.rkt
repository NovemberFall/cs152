#lang racket

(displayln "foldl")
;(foldl cons '() '(1 2 3 4))
(cons 4
    (cons 3
        (cons 2
            (cons 1 '())
        )
    )
)

(displayln "...")
(displayln "foldr")

;(foldr cons '() '(1 2 3 4))
(cons 1
    (cons 2
        (cons 3
            (cons 4 '())
        )
    )
)




(displayln "...")
(foldl (lambda (a b result)
           (* result (- a b)))
         1
         '(1 2 3)
         '(4 5 6)
)
; 1 => result
; '(1 2 3) => a
; '(4 5 6) => b