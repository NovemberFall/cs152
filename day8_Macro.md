## my-if

```scheme
#lang racket
(define (my-if c thn els)
    (cond
        [(and (list? c) (empty? c)) els]
        [(and (number? c) (= 0 c)) els]
        [(and (boolean? c) (not c)) els]
        [else thn]
    )
)


(my-if #t 1 0) ;; returns 1
(my-if 1 1 0) ;; also returns 1
(my-if #f 1 0) ;; returns 0
(my-if '() 1 0) ;; also returns 0, since (list? '()) => true,   (empty? '()) => true

(my-if #t
    (displayln "true")
    (displayln "false")
)

1
1
0
0
true
false
```

```
> (list? #t)
#f
> (empty? 1)
#f
> (number? 1)
#t
> (= 0 1)
#f
> (boolean? 1)
#f
> 

> (list? '())
#t
> (empty? '())
#t
```
---

## set!
```scheme
(define x 3)

(define (foo)
  (define x 4)
  x)

(define (bar)
  (set! x 4)
  x)

(foo) ; returns 4
x     ; still 3
(bar) ; returns 4
x     ; is now 4
```
- As you can see, when we create a new lexical scope (such as when we define a function), 
any names defined within that scope mask the names that appear in the enclosing scope. 
This means that when we defined `x` to `4` in `foo`, 
we really created a new value for `x` that shadowed the old value. 
In `bar`, since `foo` does not exist in that scope, 
`set!` looks to the enclosing scope to find, and change, the value of `x`.

## Macros in Scheme
