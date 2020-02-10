(define (managers-only lst)
    (filter
        (λ (emp) (eq? (cadddr emp) ("Manager")))
        lst    
    )
)