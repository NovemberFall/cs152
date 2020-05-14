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