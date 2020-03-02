#lang racket

(require racket/contract)

(struct account (balance))

(provide new-account balance withdraw deposit account)

;; A new, empty account
(define new-account (account 0))

;; we can not use negative number, it will generate error
(define/contract (ensurePositive acc)
  (account? . -> . boolean?)
  (if (< (balance acc) 0) 
      #f 
      #t))

;; Get the current balance
(define/contract (balance acc)
    (-> account? number?)
    (account-balance acc))

;; Withdraw funds from an account
(define/contract (withdraw acc amt)
  ;(account? (-> (and/c number? positive?) (and/c account? ensurePositive)))
  (account? (and/c number? positive?) . -> . (and/c account? ensurePositive))
  (account (- (account-balance acc) amt))
)

;; Add funds to an account
(define (deposit acc amt)
  ;;(account? (-> (and/c number? positive?) (and/c account? ensurePositive)))
  (account? (and/c number? positive?) . -> . (and/c account? ensurePositive))
  (account (+ (account-balance acc) amt)))