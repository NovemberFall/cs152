## `let and let*`
```scheme
(let ([x 3]
        [y (* x 2)])
  (displayln y))  
```
![](img/2020-02-01-14-45-03.png)
-
- use let*
```scheme
(let* ([x 3]                                                                               
        [y (* x 2)])                                                                              
        (displayln y))

=> 6
```
---


## Note:
- All the data types discussed so far are called s-expressions (s for symbolic)
- Note the programs themselves are also s-expressions. `Programs are data`
```scheme
All the data types discussed here can be lumped together into a single all-encompassing data type called the s-expression (s for symbolic). Thus 42, #\c, (1 . 2), #(a b c), "Hello", (quote xyz), (string‑>number "16"), and (begin (display "Hello, World!") (newline)) are all s-expressions.
```
---

## Lambdas λ
```scheme
(define my-add (λ (x y) (+ x y)))

(my-add 3 4)

=> 7

;Lambdas λ
((λ
   (x)
   (* x x) )
   3)

=> 9



;
(define square
    (λ 
    (x) 
    (* x x))
    )
(square 4)    

=> 16






;Alternate Format
(define (square x)
    (* x x)
)
(square 5)

=> 25


```
---



## Scheme method with contracts
![](img/2020-02-01-16-29-05.png)

#### Programming contracts
- Similar to types, but:
    - A runtime enforcement mechanism
    - Can enforce more sophisticated
        restrictions
![](img/2020-02-01-16-32-29.png)
```scheme
#lang racket
(define/contract (square x)
(-> number? number?)
(* x x))

(square 4)
(square "four")
```
![](img/2020-02-01-16-33-40.png)
---


## If Statements
- Like all languages, Scheme provides conditionals. The basic form is the if:
```scheme
(if test-expression
    then-branch
    else-branch)
```

```scheme
(define p 80)

(if (> p 70) 
    'safe
    'unsafe)
=>  safe 

(if (< p 90)
    'low-pressure) ;no ``else'' branch
=>  low-pressure 
```

- cond
- The cond form is convenient for expressing nested if-expressions, where each “else” branch but the last introduces a new if. Thus, the form
```scheme
(cond ((char<? c #\c) -1)
      ((char=? c #\c) 0)
      (else 1))
```
---



## Recursion
- Base case
    - when to stop
- Recursive step
    - calls function with a smaller version of the same problem
```scheme
(define factorial
  (lambda (n)
    (if (= n 0) 1
        (* n (factorial (- n 1))))))
```



```scheme
(define is-even?
  (lambda (n)
    (if (= n 0) #t
        (is-odd? (- n 1)))))

(define is-odd?
  (lambda (n)
    (if (= n 0) #f
        (is-even? (- n 1)))))

 (is-even? 45)
 => #f
 
 (is-odd? 45)
=> #t
```






```scheme
```











