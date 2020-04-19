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