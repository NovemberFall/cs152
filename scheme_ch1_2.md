## Data types

1. Booleans
```scheme
(boolean? #t)              =>  #t
(boolean? "Hello, World!") =>  #f


(not #f)              =>  #t
(not #t)              =>  #f
(not "Hello, World!") =>  #f

(and #t #f)           =>  #f
```
---
2. Numbers
```scheme
(number? 42)       =>  #t
(number? #t)       =>  #f
(complex? 2+3i)    =>  #t
(real? 2+3i)       =>  #f
(real? 3.1416)     =>  #t
(real? 22/7)       =>  #t
(real? 42)         =>  #t
(rational? 2+3i)   =>  #f
(rational? 3.1416) =>  #t
(rational? 22/7)   =>  #t
(integer? 22/7)    =>  #f
(integer? 42)      =>  #t

(= 42 42)   =>  #t
(= 42 #f)   -->ERROR!!!
(= 42 42.0) =>  #t

(< 3 2)    =>  #f
(>= 4.5 3) =>  #t

(+ 1 2 3)    =>  6
(- 5.3 2)    =>  3.3
(- 5 2 1)    =>  2
(* 1 2 3)    =>  6
(/ 6 3)      =>  2
(/ 22 7)     =>  22/7
(expt 2 3)   =>  8
(expt 4 1/2) =>  2.0
(/ 3 4) => 3/4

;For a single argument, ‑ and / return the negation and the reciprocal respectively:
(- 4) =>  -4
(/ 4) =>  1/4

(max 1 3 4 2 3) =>  4
(min 1 3 4 2 3) =>  1

(abs  3) =>  3
(abs -4) =>  4
```

## Characters
- Scheme character data are represented by prefixing the character with #\. Thus, #\c is the character c. Some non-graphic characters have more descriptive names, eg, #\newline, #\tab. The character for space can be written #\  , or more readably, #\space.
```scheme
(char? #\c) =>  #t
(char? 1)   =>  #f
(char? #\;) =>  #t
;Note that a semicolon character datum does not trigger a comment.

;

;The character data type has its set of comparison predicates: char=?, char<?, char<=?, char>?, char>=?.
(char=? #\a #\a)  =>  #t
(char<? #\a #\b)  =>  #t
(char>=? #\a #\b) =>  #f



;To make the comparisons case-insensitive, use char‑ci instead of char in the procedure name:
(char-ci=? #\a #\A) =>  #t
(char-ci<? #\a #\B) =>  #t



;The case conversion procedures are char‑downcase and char‑upcase:
(char-downcase #\A) =>  #\a
(char-upcase #\a)   =>  #\A
```
---

```scheme
```
```scheme
```
