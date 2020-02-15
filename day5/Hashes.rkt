#lang racket
(define ht (hash "a" 1 "b" 2))

(hash-ref ht "a") ; 1
(hash-ref ht "b") ; 2
(hash-ref ht "c" 0) ; 0
(hash-ref ht "a" 0) ; 1



(define ht2 (hash-set ht "c" 42))   ; updating hash
(hash-ref ht2 "c" 0) ; 42
(hash-ref ht2 "b" 0) ; 42
(hash-ref ht "c" 0) ; 0