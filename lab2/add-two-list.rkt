#lang racket
(define (add-two-lists lst1 lst2)
    (cond [(and (null? lst1) (null? lst2) '())]
          [(null? lst1) (append lst2)]
          [(null? lst2) (append lst1)]
          [(= (length lst1) (length lst2)) 
              (append (list (+ (car lst1) (car lst2)))
                      (add-two-lists (cdr lst1) (cdr lst2))
              )
          ]
          [(if (> (length lst1) (length lst2))
              (define lst2 (append lst2 '(0)))
              (append (list (+ (car lst1) (car lst2)))
                      (add-two-lists (cdr lst1) (cdr lst2))
              )
           )
          ]
          [(if (< (length lst1) (length lst2))
              (define lst1 (append lst1 '(0)))
              (append (list (+ (car lst1) (car lst2)))
                      (add-two-lists (cdr lst1) (cdr lst2))
              )
           )
          ]
    )
)



;; Join two lists together by adding their elements.
;; If one list is longer than the other, add the
;; additional elements to the end of the list.
(define (add-two-lists lst1 lst2)
    ; (displayln (car lst1))
    ; (displayln (car lst2))
    (cond
        [(and (null? lst1) (null? lst2) '())]
        [(null? lst1) (append lst2)]
        [(null? lst2) (append lst1)]
        [(and (< 1 (length lst1)) (< 1 (length lst2)))
            (append
                (list (+ (car lst1) (car lst2)))
                (add-two-lists (cdr lst1) (cdr lst2))
            )
        ]
        [else
            (append
                (list (+ (car lst1) (car lst2)))
                (cdr lst1)
                (cdr lst2)
            )
        ]
    )
)





(define (add-two-lists lst1 lst2)
  (define (different-lists lst1 lst2 remainder)
      (if (= (length lst1) (length lst2))
          (addSameSizeList lst1 lst2 '())
          (cond [(= remainder 0)
                   (different-lists (append lst1 '(0)) lst2 remainder)
                ]
                [(= remainder 1)
                    (different-lists lst1 (append lst2 '(0)) remainder)   
                ]
          )
      )
  )

  (define (addSameSizeList lst1 lst2 listEmptyPosition)
      (if (< (length lst1) 1)
          listEmptyPosition ; return empty list
          (addSameSizeList (cdr lst1) (cdr lst2) 
            (append listEmptyPosition (list (+ (car lst1) (car lst2))))
          ); else statement recursing
      )
  )

  (cond [(= (length lst1) (length lst2)) 
            (addSameSizeList lst1 lst2 '())
        ]
        [(< (length lst1) (length lst2)) 
            (different-lists lst1 lst2 0)
        ]
        [(> (length lst1) (length lst2)) 
            (different-lists lst1 lst2 1)
        ]
  )
)

