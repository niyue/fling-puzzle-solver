Fling puzzle solver
===================

This program is written to solve puzzles in Fling, an iPhone puzzle game.

![Fling iPhone app screenshot](http://farm5.static.flickr.com/4153/4993541140_e606ce387d.jpg "Fling! iPhone app screenshot")

Build and Installation
===================
1. Install Apache Maven
2. Download source code
3. mvn assembly:assembly
4. It's done.

Usage
======================
There's a command line interface to solve Fling puzzle. 
java -jar fling-puzzle-solver-1.0-jar-with-dependencies.jar /path/to/your/puzzle.data
1. Here fling-puzzle-solver-1.0-jar-with-dependencies.jar is in target directory after running "mvn assembly:assembly".
2. puzzle.data is a csv file, which is a 7x8 board like below:
 <blockquote>
FBALL, false, false, false, false, FBALL, false
false, false, false, false, false, false, false
false, false, false, false, false, false, FBALL
false, false, false, false, FBALL, false, false
false, false, false, false, false, false, false
false, false, false, false, false, false, false
false, false, false, false, false, false, false
false, false, false, false, false, false, false
</blockquote>
	1. 'FBALL' means there's a fling furball in the cell.
	2. 'false' means this is an empty cell.

The CLI will output the solution in the console like below:
<blockquote>
(1, 1) RIGHT
(5, 1) DOWN
(5, 3) RIGHT
</blockquote>
It is the list of movements you have to take to solve this puzzle. 
Each movement is consist of "(x, y) DIRECTION" as instruction, which means you have to move the furball in (x, y) with DIRECTION.
