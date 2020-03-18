#lang racket

; Exports.  In Java terminology, these functions are public.
(provide rectangle-area square-area triangle-area)

; Returns the area of a rectangle.
; If the area would be negative, the absolute value is returned instead.
(define (rectangle-area w h)
  (abs (* w h))
  )
; Returns the area of a square.
(define (square-area s)
  (* s s)
  )

; Returns the area of a triangle.
(define (triangle-area b h)
  (abs (* 1/2 b h))
  )

(rectangle-area -35 2)

(square-area 3.3)

(triangle-area 2 15)