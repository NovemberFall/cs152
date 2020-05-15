heists(joker, 97). 
heists(penguin, 18). 
heists(catwoman, 31). 
heists(scarecrow, 42).

combined_heists(X, Y, Total) :- 
		heists(X,XN), heists(Y,YN), 
		Total is XN + YN.
		% Total = XN + YN.



%rules

add_3_and_double(X,Y) :- Y is (X+3)*2.



%rules - no cuts 
max(X,Y,Y) :- X =< Y.
max(X,Y,X) :- X > Y. 