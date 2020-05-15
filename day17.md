### day17 prolog


![](img/2020-05-14-16-34-38.png)
![](img/2020-05-14-16-45-29.png)




## The Cut Operator

### no cuts

![](img/2020-05-14-17-33-53.png)

- why need cuts? since if without cut, it still continue search? 
![](img/2020-05-14-17-34-56.png)


### Green cut

![](img/2020-05-14-17-43-09.png)
![](img/2020-05-14-18-16-09.png)
![](img/2020-05-14-18-17-30.png)

- after green cut, you don't need consider the second match.





- batman.prolog

```js
villain(joker).
villain(penguin).
villain(catwoman).
villain(scarecrow).
villain(bane).

kills_people(joker).
kills_people(penguin).
kills_people(bane).

power(scarecrow, fear).
power(bane,venom).

% Rules
scary(V) :- villain(V), kills_people(V).
scary(V) :- villain(V), power(V,_).

% ?- findall(V, scary(V), R).
% R = [joker, penguin, bane, scarecrow, bane].
% 
% ?- setof(V, scary(V), R).  
% R = [bane, joker, penguin, scarecrow].

% What if we did not have setof?
find_scary(ScarySet) :-
  findall(V, scary(V), ListOfScaries),
  get_unique(ListOfScaries,ScarySet),
  !. % Green cut

get_unique([],[]).
get_unique([H|Tail], Set) :-
  get_unique(Tail, TailSet),
  \+ member(H, TailSet),
  Set = [H|TailSet].
get_unique([H|Tail], Set) :-
  get_unique(Tail, TailSet),
  member(H, TailSet),
  Set = TailSet.
```

- who is going to be the first scary villain?
![](img/2020-04-19-02-34-22.png)
![](img/2020-04-19-02-50-46.png)


---


## Arithmetic in Prolog
![](img/2020-04-19-02-54-59.png)
![](img/2020-04-19-03-06-13.png)

![](img/2020-04-19-03-08-50.png)

```js
heists(joker, 97). 
heists(penguin, 18). 
heists(catwoman, 31). 
heists(scarecrow, 42).

combined_heists(X, Y, Total) :- 
		heists(X,XN), heists(Y,YN), 
		Total is XN + YN.
```
![](img/2020-04-19-03-10-08.png)

---

## The Cut Operator
![](img/2020-04-19-03-13-11.png)
![](img/2020-04-19-03-13-34.png)
![](img/2020-04-19-03-17-04.png)


---


## List in Prolog
![](img/2020-04-19-22-33-26.png)

### Prolog list solutions are often recursive.

![](img/2020-05-14-18-42-45.png)
![](img/2020-05-14-18-59-09.png)

- append method.

![](img/2020-05-14-20-00-44.png)

- myappend method:

```ruby
myappend([], L2, L2).   %base case
myappend([H|T1], L2, [H|T2]) :- myappend(T1, L2, T2). %Recursive case
```

- Prefix

![](img/2020-05-14-20-12-30.png)

---


## Reversing a List

```ruby
myreverse([], []).
myreverse([H|T], L) :- myreverse(T, RT), append(RT, [H], L).




naiverev([],[]).
naiverev([H|T],R):-  naiverev(T,RevT),  append(RevT,[H],R).
```

- using Accumulator:

```ruby
   List:  [a,b,c,d]    Accumulator:  []
   List:  [b,c,d]        Accumulator:  [a]
   List:  [c,d]            Accumulator:  [b,a]
   List:  [d]                Accumulator:  [c,b,a]
   List:  []                  Accumulator:  [d,c,b,a]

 
    accRev([H|T],A,R):-  accRev(T,[H|A],R).
    accRev([],A,A).
```

---


## Graph

