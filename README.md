# MontyHallPuzzle

This is a simulation of the Monty Hall puzzle.

## Description

The Monty Hall Three-Door Puzzle Suppose you are a game show contestant. You have a
chance to win a large prize. You are asked to select one of three doors to open; the large prize is
behind one of the three doors and the other two doors are losers. Once you select a door, the
game show host, who knows what is behind each door, does the following. First, whether or not
you selected the winning door, he opens one of the other two doors that he knows is a losing
door (selecting at random if both are losing doors). Then he asks you whether you would like to
switch doors. Which strategy should you use? Should you change doors or keep your original
selection, or does it not matter?

### How to use this project
This project was made with Java. To compile this project you need to have Java(JVM) installed on your computer.

There are a couple ways to compile Java files.

#### Compile it using the terminal.
Clone or download the zip file.

Open your terminal and enter the directory `cd MontyHallPuzzle`

Go into the source files `cd src`

Compile all .java files `javac *.java`

Then run the main file `java main`

#### Compile it with your favorite IDE.
You can also use your favorite IDE to compile and run this program. I reccomend using IntelliJ IDEA however, there are
many other good ones to use. I will not go in depth for each IDE but you should be able to copy the source files into a
project and run the main method.

## Findings
This simulation runs the game 1,000,000 times with counting the winning strategy after each game. 
The results average to the winning strategy being switching 2/3 of the games played while staying has a 1/3 success rate.
This means that if you are ever playing this game, you should switch after one door has been removed because you will 
have a 2/3 success rate.
