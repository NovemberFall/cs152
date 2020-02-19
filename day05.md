## for lab3, part3
```racket
(define (managers-only lst)
    (filter
        (λ (emp) (eq? (cadddr emp) ("Manager")))
        lst    
    )
)
```
---

## caddr means:
```ruby
(cadddr x)
=> 
    (car
        (cdr 
            (cdr 
                (cdr x)
            )
        )
    )
```

---

## Fold variants
![](img/2020-02-10-22-50-07.png)

![](img/2020-02-19-12-45-30.png)

