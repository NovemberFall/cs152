## Introduction to Prolog

![](img/2020-04-18-03-05-35.png)

- if X is a man, then X is mortal
- if X is a woman, then X is mortal
- X is a capital letter, not a lowercase x that means this is a variable, if it starts with 
  lowercase letter, it's not variable

- comma, is `and`
---


### Using not
![](img/2020-04-18-03-40-47.png)
![](img/2020-04-18-03-41-24.png)


- `X \= jamie` ; != , different than not

![](img/2020-04-18-14-26-15.png)

- one thing here, you can put `not(...)` first

![](img/2020-04-18-14-27-00.png)
![](img/2020-04-18-14-28-26.png)
- this won't give us any results back, so this will always return false 

---

## Game of Thrones in Prolog 

- create a folder `day16/GOT.prolog`

```js
king(robert).
wife(cersei,robert).

brother(jamie,cersei). 
brother(jamie,tyrion). 
brother(tyrion,jamie).

friend(robert,ned). 
friend(robert,jon_arryn). 
friend(tyrion,bronn). 
friend(tyrion,jamie).

enemy(cersei, X) :- friend(robert,X). 
enemy(cersei, X) :- friend(tyrion,X), X \= jamie. 
enemy(jamie, X) :- enemy(cersei,X),
					not(brother(jamie,X)). 

queen(X) :- wife(X,Y), king(Y).
```

![](img/2020-04-18-14-49-22.png)

![](img/2020-04-18-14-54-28.png)

- Note, can not use lowercase letter.

![](img/2020-04-18-14-57-37.png)

- A semicolon means that I want more results.
- A period means I'm done.

---

## 或者cd 到当前路径， run `swipl` => [got]. => true

![](img/2020-04-19-01-20-08.png)

- update `GOT.prolog`

```js
king(robert).
wife(cersei,robert).

brother(jamie,cersei). 
brother(jamie,tyrion). 
brother(tyrion,jamie).

friend(robert,ned). 
friend(robert,jon_arryn). 
friend(tyrion,bronn). 
friend(tyrion,jamie).

enemy(tyrion, littlefinger).
enemy(cersei, robert).
enemy(cersei, tyrion).

%Rules
enemy(cersei, X) :- friend(robert,X). 
enemy(cersei, X) :- friend(tyrion,X), X \= jamie. 
enemy(jamie, X) :- enemy(cersei,X),
					not(brother(jamie,X)). 

queen(X) :- wife(X,Y), king(Y).
```
---

![](img/2020-04-19-01-27-11.png)

