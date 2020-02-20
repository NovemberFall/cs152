#lang racket

;; Expressions in the language
(struct b-val (val))
(struct b-if (c thn els))
(struct b-succ (expression))
(struct b-pred (expression))

;; An expression is represented by one of our structs above.
(define (expression? e)
  (match e
    [(struct b-val (v)) v]
    [(struct b-if (c thn els))
     (if (number? c)
         (cond [(> c 0) #t]
               [else #f])
         (if (evaluate c)
             (evaluate thn)
             (evaluate els)))
    ]
    [(struct b-succ (e)) (+ (evaluate e) 1)]
    [(struct b-pred (e)) (- (evaluate e) 1)]
    [_ #f]))

;; A value will be either a Scheme boolean value or a Scheme number.
(define (value? v)
  (or (number? v)
      (boolean? v)))


;; Main evaluate method
(define/contract (evaluate prog)
  (-> expression? value?)
  (match prog
    [(struct b-val (v)) v]
    [(struct b-if (c thn els))
     (if (evaluate c)
         (evaluate thn)
         (evaluate els))]
    [_ (error "Unrecognized expression")]))

;; true
(evaluate (b-val #t))

;; false
(evaluate (b-val #f))

;; if true then
;;    (if false then true else false)
;; else false
(evaluate (b-if (b-val #t)
                (b-if (b-val #f) (b-val #t) (b-val #f))
                (b-val #f)))

;; Consider the following sample programs for extending the interpreter
; succ 1  =>  returns 2
; succ (succ 7) => returns 9
; pred 5 => returns 4
; succ (if true then 42 else 0) => 43