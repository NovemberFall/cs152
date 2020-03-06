#lang racket
(positive? 3)

(positive? -2)

(filter positive?
    '(1 2 -3 4 0 5)
)

;combining higher-order functions
(displayln "")


(map (λ (x) (* x x))
    (filter even?
        '(1 2 3 4 5 6)
    )
)