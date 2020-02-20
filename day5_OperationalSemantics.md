## Structs
![](img/2020-02-19-12-13-53.png)
![](img/2020-02-19-12-13-08.png)
![](img/2020-02-19-12-13-31.png)

```scheme
#lang racket
(struct employee (fname lname salary))
(struct manger (fname lname salary bonus))

(define (calc-wages emp)
    (match emp
        [(struct employee (first last sal)) ;new variables
            sal]
        [(strcut manager ( _ _ sal extra))
            (+ sal extra)]
    [ _ _ (error "Not on employee")]
    )
)


{let ([dilbert (employee "Dilbert" "Adams" 80000)]
      [aice (employee "Alice" "Rage" 95000)]
      [phb (manager "PoirtyHaired" "Boss" 105000 200000)])
    (displayln (calc-wages dilbert))
    (displayln (calc-wages alice))
    (displayln (calc-wages phb))
}
```

---

## Bool* big-step example
![](img/2020-02-19-12-34-56.png)
![](img/2020-02-19-12-35-20.png)
---


## Extended Bool* Language
![](img/2020-02-19-12-36-05.png)
![](img/2020-02-19-12-44-15.png)
![](img/2020-02-19-12-44-33.png)

