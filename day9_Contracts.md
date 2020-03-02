## Contract Violations

- `contract-out` specifies the requirements.
```scheme
#lang racket
 
(provide (contract-out [amount positive?]))
 
(define amount 'amount)
```
![](img/2020-03-02-09-20-17.png)
---

- To make the contract capture our intentions for all Racket values, 
we can ensure that the value is both a number and is positive, combining the two contracts with `and/c`
```scheme
#lang racket

(provide (contract-out  [amount (and/c number? positive?)])
)

(define amount 2)
```
---

## Simple Contracts on Functions
- Recall:
  - A mathematical function has a domain and a range. 
    The domain indicates the kind of values that the function can accept as arguments, 
    and the range indicates the kind of values that it produces
    `f : A -> B`,  where A is the domain of the function and B is the range.

- Functions in a programming language have domains and ranges, too, 
  and a contract can ensure that a function receives only values in its domain 
  and produces only values in its range.
  `A ->` creates such a contract for a function. 
  The forms after `a ->` specify contracts for the domains and finally a contract for the range.

```scheme
(provide (contract-out
          [deposit (-> number? any)]
          [balance (-> number?)]))
 
(define amount 0)
(define (deposit a) (set! amount (+ amount a)))
(define (balance) amount)
```
- The module exports two functions:
  1. `deposit`, which accepts a number and returns some value that is not specified in the contract, and
  2. `balance`, which returns a number indicating the current balance of the account.

- `A ->` by itself is not a contract; 
  it is a contract combinator, which combines other contracts to form a contract.
---


## Styles of ->
- If you are used to mathematical functions, 
  you may prefer a contract arrow to appear between the domain and the range of a function, 
  not at the beginning. If you have read How to Design Programs, you have seen this many times. 
  Indeed, you may have seen contracts such as these in other people’s code:
```scheme
(provide (contract-out
          [deposit (number? . -> . any)]))
```





```scheme
```
```scheme
```
```scheme
```