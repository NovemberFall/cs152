## Introduction to Prolog

![](img/2020-04-18-03-05-35.png)

- if X is a man, then X is mortal
- if X is a woman, then X is mortal
- X is a capital letter, not a lowercase x that means this is a variable, if it starts with 
  lowercase letter, it's not variable

- comma, is `and`
-  `.` here, it's equivalent to a semicolon in Java

- 主要在terminal,  ?- [文件名].   //=> return 文件里的内容
---


### Using not
![](img/2020-04-18-03-40-47.png)
![](img/2020-04-18-03-41-24.png)
- `\+immortal(X).`
- here is another syntax for not
- exactly same with `not`

---

### loading Proglo file
![](img/2020-05-13-23-28-35.png)

```ruby
%facts
man(socrates). 
man(zeus). 
woman(helen).

immortal(zeus).

%Rules
mortal(X) :- man(X), not(immortal(X)). 
mortal(X) :- woman(X).

married(socrates).
married(helen).

husband(Person) :- married(Person),
				   man(Person).
```
![](img/2020-05-13-23-33-10.png)
![](img/2020-05-14-02-13-25.png)




---
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


![](img/2020-05-14-11-26-35.png)


- who is queen?
- we can use first letter is capital method does this. I am looking to get an ans for this.

![](img/2020-05-14-11-31-42.png)
- remember, if hit q, it doen't work.

![](img/2020-05-14-11-34-01.png)
- agian, 第一个字母大写代表，变量
---

```ruby

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



![](img/2020-04-19-01-27-11.png)




