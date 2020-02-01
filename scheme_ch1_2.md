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

## Symbols
```scheme
;The simple data types we saw above are self-evaluating. Ie, if you typed any object from these data types to the listener, the evaluated result returned by the listener will be the same as what you typed in.
#t  =>  #t
42  =>  42
#\c =>  #\c
```
- Symbols don’t behave the same way. This is because symbols are used by Scheme programs as `identifiers` for `variables`, and thus will evaluate to the value that the variable holds. Nevertheless, symbols are a simple data type, and symbols are legitimate values that Scheme can traffic in, along with characters, numbers, and the rest.
```scheme
;To specify a symbol without making Scheme think it is a variable, you should quote the symbol:
(quote xyz)
=>  xyz

;Since this type of quoting is very common in Scheme, a convenient abbreviation is provided. The expression
'E

;will be treated by Scheme as equivalent to
(qutoe E)



(symbol? 'xyz) =>  #t
(symbol? 42)   =>  #f


;Scheme symbols are normally case-insensitive. Thus the symbols Calorie and calorie are identical:



;We can use the symbol xyz as a global variable by using the form define:
(define xyz 9)
;This says the variable xyz holds the value 9. If we feed xyz to the listener, the result will be the value held by xyz:
xyz
=>  9

;We can use the form set! to change the value held by a variable:
(set! xyz #\c)
;Now:
xyz
=>  #\c
```
---



## Compound data types

1. Strings
```scheme
"Hello, World!"
=>  "Hello, World!"


;The procedure string takes a bunch of characters and returns the string made from them:
(string #\h #\e #\l #\l #\o)
=>  "hello"

;Let us now define a global variable greeting.
(define greeting "Hello; Hello!")
;Note that a semicolon inside a string datum does not trigger a comment.

;The characters in a given string can be individually accessed and modified. The procedure string‑ref takes a string and a (0-based) index, and returns the character at that index:
(string-ref greeting 0)
=>  #\H

;New strings can be created by appending other strings:
(string-append "E "
               "Pluribus "
               "Unum")
=>  "E Pluribus Unum"



;You can make a string of a specified length, and fill it with the desired characters later.
(define hello (string #\H #\e #\l #\l #\o)) 
hello
=>  "Hello"

(string-set! hello 1 #\a)
hello
=>  "Hallo"
```
--- 


2. Vectors
```scheme
;Vectors are sequences like strings, but their elements can be anything, not just characters. Indeed, the elements can be vectors themselves, which is a good way to generate multidimensional vectors.
(vector 0 1 2 3 4)
=>  #(0 1 2 3 4)
```
---



3. Dotted pairs and lists
```scheme
;A dotted pair is a compound value made by combining any two arbitrary values into an ordered couple. The first element is called the car, the second element is called the cdr, and the combining procedure is cons.
Lists: '(1 2 3 4) 
(car '(1 2 3 4)) => 1
(cdr '(1 2 3 4)) => '(2 3 4) 
(cons 9 '(8 7)) =>'(9 8 7)





(cons 1 #t)
=>  (1 . #t)

;Dotted pairs are not self-evaluating, and so to specify them directly as data (ie, without producing them via a cons-call), one must explicitly quote them:
'(1 . #t) =>  (1 . #t)
(1 . #t)  -->ERROR!!!


;The accessor procedures are car and cdr:
(define x (cons 1 #t))

(car x)
=>  1

(cdr x)
=>  #t


;The elements of a dotted pair can be replaced by the mutator procedures set‑car! and set‑cdr!:
(set-car! x 2)

(set-cdr! x #f)

x
=>  (2 . #f)


;Dotted pairs can contain other dotted pairs.
(define y (cons (cons 1 2) 3))

y
=>  ((1 . 2) . 3)

;The car of the car of this list is 1. The cdr of the car of this list is 2. Ie,
(car (car y))
=>  1

(cdr (car y))
=>  2

;Scheme provides procedure abbreviations for cascaded compositions of the car and cdr procedures. Thus, caar stands for “car of car of”, and cdar stands for “cdr of car of”, etc.
(caar y)
=>  1

(cdar y)
=>  2


;c...r-style abbreviations for upto four cascades are guaranteed to exist. Thus, cadr, cdadr, and cdaddr are all valid. cdadadr might be pushing it.

;When nested dotting occurs along the second element, Scheme uses a special notation to represent the resulting expression:
(cons 1 (cons 2 (cons 3 (cons 4 5))))
=>  (1 2 3 4 . 5)
;Ie, (1 2 3 4 . 5) is an abbreviation for (1 . (2 . (3 . (4 . 5)))). The last cdr of this expression is 5.



;Scheme provides a further abbreviation if the last cdr is a special object called the empty list, which is represented by the expression (). The empty list is not considered self-evaluating, and so one should quote it when supplying it as a value in a program:
'() =>  ()

;The abbreviation for a dotted pair of the form (1 . (2 . (3 . (4 . ())))) is
(1 2 3 4)

;This special kind of nested dotted pair is called a list. This particular list is four elements long. It could have been created by saying
(cons 1 (cons 2 (cons 3 (cons 4 '()))))

;but Scheme provides a procedure called list that makes list creation more convenient. list takes any number of arguments and returns the list containing them:
(list 1 2 3 4)
=>  (1 2 3 4)

;Indeed, if we know all the elements of a list, we can use quote to specify the list:
'(1 2 3 4)
=>  (1 2 3 4)



;List elements can be accessed by index.
(define y (list 1 2 3 4))

(list-ref y 0) =>  1
(list-ref y 3) =>  4

(list-tail y 1) =>  (2 3 4)
(list-tail y 3) =>  (4)
;list‑tail returns the tail of the list starting from the given index.



;The predicates pair?, list?, and null? check if their argument is a dotted pair, list, or the empty list, respectively:
(pair? '(1 . 2)) =>  #t
(pair? '(1 2))   =>  #t
(pair? '())      =>  #f
(list? '())      =>  #t
(null? '())      =>  #t
(list? '(1 2))   =>  #t
(list? '(1 . 2)) =>  #f
(null? '(1 2))   =>  #f
(null? '(1 . 2)) =>  #f
```
---



4. Conversions between data types

- Scheme offers many procedures for converting among the data types. We already know how to convert between the character cases using char‑downcase and char‑upcase. Characters can be converted into integers using char‑>integer, and integers can be converted into characters using integer‑>char. (The integer corresponding to a character is usually its ascii code.)
```scheme
(char->integer #\d) =>  100
(integer->char 50)  =>  #\2


;Strings can be converted into the corresponding list of characters.
(string->list "hello") =>  (#\h #\e #\l #\l #\o)


;Other conversion procedures in the same vein are list‑>string, vector‑>list, and list‑>vector.

```





```scheme
```








