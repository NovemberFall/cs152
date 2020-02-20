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

<<<<<<< HEAD
---



## Big-step semantics for Bool
```js
e:: = true
    | false
    | if e then e else e
```

```
v :: = true
    | false
```
---

## Bool* extension: numbers
```js
e:: = true
    | false
    | if e then e else e
    | n
    | succ e
    | pred e
```
```js
v :: = true
     | false
     | n
```


=======
![](img/2020-02-19-12-45-30.png)
>>>>>>> bd2214e0a2b071f9757374f4cbaf593a57decb00

