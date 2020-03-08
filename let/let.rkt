#lang racket

(let ((i 1) (j 2))
    (+ i j)
)
(displayln " ")

(let ((i 1))
    (let ((j (+ i 2)))
        (* i j)
    )
)
(displayln " ")

(displayln "let*表达式可以用于引用定义在同一个绑定中的变量。实际上，let*只是嵌套的let表达式的语法糖而已。")

(let* ((i 1) (j (+ i 2)))
    (* i j)
)