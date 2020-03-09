## lab5

https://stackoverflow.com/questions/1047454/what-is-lexical-scope

```scheme
(define/contract (evaluate prog)
    (-> expression? value?)
    (match prog
        [...]
        [(struct b-succ (exp))
            
        ]
    )
)
```


## What is lexical scope? 词法域

- first, lexical scope (also called static scope), in C
```c
void fun(){
    int x = 5;

    void fun2(){
        printf("%d", x);
    }
}
```
- Every inner level can access its outer levels.
- There is another way, called dynamic scope used 
  by the first implementation of Lisp, again in a C-like syntax:
```c
void fun()
{
    printf("%d", x);
}

void dummy1()
{
    int x = 5;

    fun();
}

void dummy2()
{
    int x = 10;

    fun();
}
```
- Here fun can either access x in dummy1 or dummy2, 
  or any x in any function that call fun with x declared in it.

- `dummy1();`  // print 5
- `dummy2();`  // print 10

1. The first one is called `static` because it can be deduced at compile-time, 
   and the second is called `dynamic` because the outer scope is `dynamic` and depends on the chain call of the functions.

2. I find `static scoping` easier for the eye. Most languages went this way
   eventually, even Lisp (can do both, right?). `Dynamic scoping` is like passing references of all variables to the called function.

3. As an example of why the compiler can not deduce the outer dynamic scope of a
   function, consider our last example. If we write something like this:
```c
if(/* some condition */)
    dummy1();
else
    dummy2();
```

- The call chain depends on a run time condition. If it is true, then the call chain
  looks like:

`dummy1 --> fun()`
If the condition is false:
`dummy2 --> fun()`

- The outer scope of `fun` in both cases is the caller plus the caller of the caller
  and so on.

- Just to mention that the C language does not allow nested functions nor dynamic scoping.
