```bash
#!/bin/bash
x = 42
funcionn foo{
    echo $x
}
function bar{
    local x=666
    foo
}
bar
```


---

- In static on lexical scoping name resolution depends on where the named variable is defined


- In dynamic scoping, name resolution depends on the execution path of the code (the calling context)

- A closure is a part of a function and its environment
- An environment is a mapping of free variables to their values defined outside the function

```scheme
(define (make-adder x)
   (lambda(y) (+ x y)) )

(let ([add-tow]

))
```




```scheme
(define (make-counter)
    (let ([count 0])
        (lambda ()
            (set! count (+ count 1))
        count)
    )
)
(define my-count (make-counter))
(my-count); 1
(my-count); 2

(define ctr2 (make-counter))
(ctr2);1
(mycount);
```


```scheme
(define (box x)
    (conse
        (lambda() x)
        (lambda(y) (set! x y))
    )
)

(define (get-val bx)
    ((car bx))
)

(define (set-val! bx new-val)
    ((cdr bx) new-val)
)
```