/* all the males in the family*/
male(pete).
male(tom).
male(mark).
male(john).
male(frank).
male(matt).
male(todd).
male(henry).
/* all the females in the family */
female(anne).
female(lilly).
female(kate).
female(alice).
female(jenny).
/*all of the parents in the family*/
parent(pete, mark).
parent(pete, tom).
parent(pete, anne).
parent(mark, lilly).
parent(mark, john).
parent(mark, frank).
parent(tom, kate).
parent(anne, alice).
parent(anne, matt).
parent(matt, jenny).
parent(matt, todd).
parent(alice,henry).
/*X is a sibling to Y if and only if Z is a parent of x and Z is a parent of Y.*/
sibling(X,Y) :- parent(Z,X), parent(Z,Y), X\=Y.
brother(X,Y) :- male(X), sibling(X,Y).
sister(X,Y) :- female(X), sibling(X,Y).
father(X,Y) :- male(X), parent(X,Y).
mother(X,Y) :- female(X), parent(X,Y).
grandParent(GrandParent, Child) :-  parent(GrandParent,SomeParent), parent(SomeParent,Child).






