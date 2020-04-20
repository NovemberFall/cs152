### Lab17

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


## List
![](img/2020-04-19-22-33-26.png)


