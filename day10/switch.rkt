#lang racket

(define-syntax switch
    (syntax-rules (default)
        {(switch c) (vad)}
        {(switch c [default body]) body}
        {(switch c [val? body?]) body}
    )
)