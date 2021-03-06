## 引言
```
请问scheme cons 两个元素后为什么有个点
如果(cons 1 2)
则得到(1 . 2)
如果(cons 1 (cons 2 `()))
则得到(1 2)
```


```scheme
1. cons用来构造点对（pair, 或称dot pair），(cons 1 2)就得到了点对(1 . 2).
它只有两个部分，前面部分叫做car部分，后面部分叫做cdr部分。
cons可以叠加，比如你(cons 3 (cons 1 2)) 就得到 

=> (cons 3 '(1 . 2)) 可以简写为 => (3 1 . 2)

(car '(1. 2)) => 1
(cdr '(1. 2)) => 2
(cdr '(3 1 . 2)) => (1. 2)

所以你看到的那些 形如(x1 x2 ... xl xm xn . xo) 
这种最后一个元素前面加了个点的东西，都可以看成是很多次cons运算的结果。
这个东西它不叫list，按R5RS标准，它叫“非严格list”。也就是说有list的一些性质，但不那么严格。




2
要定义list，就要先定义空表。空表的外部表现是'( ), 它是一个属于自身的特殊数据类型。
表（list）可以通过递归方法来定义：表是这样的东西，要么它是个空表，要么它的cdr部分是个表。
依照这个定义，我们发现，每个表的最右边一个元素都必须是空表。（这个你可以多思考下，注意递归）
所以，其实所有的表都应该是这样的长相 '（x1 x2 ... xn '( )）。显然，长成这样子的东西，
也可以从很多个cons得到，比如你(cons 4 (cons 3 (cons 2 (cons 1 '())))), 就能得到
=> (4 . (3 . (2 . (1 . '()))))
这个东西也可以简写成
=> (4 3 2 1 . '()) 
可以看到，这个东西满足表的定义，（无论是从长相上还是从文字定义上），所以它就是个表。



3
现在来比较一下两个东西
(cons 3 (cons 2 1)) => (3. (2. 1)) => (3 2 . 1) 这个是非严格表。
(cons 3 (cons 2 (cons 1 '( )))) => (3 . (2. (1 . '( )))) => (3 2 1 . '()) 这个是表，或说严格表。



4 
一般我们要定义一个表，有两种方式:

第1，用list, (list 1 2 3) 返回表 (1 2 3), 实际上它是(1 2 3 . '()).你也许会问，它不把空表写出来，
不是跟非严格表一样了吗？当然不，如果是压根没有后面空表的非严格表，它会写成(1 2 . 3)，必定有那个点。

第2，用quote，(quote (1 2 3))就返回(1 2 3),由于quote用的太多，也简写成 ' ,即
(quote (1 2 3)) <=> '(1 2 3)

所以定义一个表往往是(define L (list 1 2 3)) 或者(define '(1 2 3)).
后面还会遇到准引用(quasiquote)，代替它的符号是`,就是英文状态下按左上角esc下面那个键。
准引用与引用的作用有所区别，这里就不讲了。

```
---



## more example
- scheme 序对pair 和 表list
```scheme
今天在看SICP 的时候发现一个问题，2.2.2层次性结构，构造一个 (cons (list 1 2) (list 3 4)) ，
输出的结果 ((1 2) 3 4) ，想象中的结果应该是 ((1 2) (3 4)) 才对啊。


我们知道，构造一个表 (list 1 2 3 4) 等价于 (cons 1 (cons 2 (cons 3 (cons 4 '())))) ，
精简一下 (list 1) 等价于 (cons 1 '()) 。
'()表示不包含任何元素的空表。也就是说 表 list 是一个以 '() 结尾的特殊的 序对 pair 。


回到刚开始的问题， (cons (list 1 2) (list 3 4)) 
等价于 (cons (cons 1 (cons 2 '())) (cons 3 (cons 4 '()))) ，
因为以'()结尾，所以该表达式返回的是一个list，而 (cons 1 (cons 2 '())) 也就是表 (1 2) ， 
是返回的表中的第一个元素，而3是第二个元素，4是第三个元素，返回表的长度是3。

对比看一下， (list (list 1 2) (list 3 4)) 等价于 (cons (list 1 2) (cons (list 1 2) '())) 等价于
(cons (cons 1 (cons 2 '())) (cons (cons 3 (cons 4 '())) '())) ，表示式返回值为 ((1 2) (3 4))
也就是说 返回的表是由表 (1 2) 和 表 (3 4)组成的，长度为2。

注意：在 chez scheme 的解释器中nil空表要用 '() 表示。

这里我突然想构造一个空表，于是在解释器里尝试了以下方法，
```


