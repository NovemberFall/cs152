# cs152

## video
http://www.eng.utah.edu/~cs5510/f16/htdp-videos.html



## https://racket-lang.org/
- Download
- https://download.racket-lang.org/


## terminal run racket
- https://stackoverflow.com/questions/33812803/running-racket-from-terminal-in-os-x
- on terminal run `ln -sf /Applications/Racket\ v7.5/bin/racket /usr/local/bin/racket`
---

## on terminal run racket
```scheme
#lang racket
(displayln "Hello World")
```

## define a function
- create function.rkt
```scheme
#lang racket

(define my-add (λ (x y) (+ x y)))

(my-add 3 4)
```
- output: 7
---


