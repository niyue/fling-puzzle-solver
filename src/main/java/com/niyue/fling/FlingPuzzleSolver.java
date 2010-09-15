package com.niyue.fling;

import java.util.Stack;
import static com.niyue.fling.Direction.*;

public class FlingPuzzleSolver {
	private static Stack<Movement> NO_SOLUTION = null;
	public Stack<Movement> solve(Board board) {
		Stack<Movement> solution = NO_SOLUTION;
		if(board.isSolved()) {
			solution = new Stack<Movement>();
		}
		else {
			for(int x=0;x<Board.DEFAULT_WIDTH;x++) {
				for(int y=0;y<Board.DEFAULT_HEIGHT;y++) {
					solution = tryMove(x, y, UP, board);
					if(foundSolution(solution))
						break;
					
					solution = tryMove(x, y, DOWN, board);
					if(foundSolution(solution))
						break;
					
					solution = tryMove(x, y, LEFT, board);
					if(foundSolution(solution))
						break;
					
					solution = tryMove(x, y, RIGHT, board);
					if(foundSolution(solution))
						break;
				}
				if(foundSolution(solution))
					break;
			}
		}
		return solution;
	}
	
	private boolean foundSolution(Stack<Movement> solution) {
		return solution != NO_SOLUTION;
	}
	
	private Stack<Movement> tryMove(int x, int y, Direction direction, Board board) {
		Stack<Movement> solution = NO_SOLUTION;
		if(board.isMovable(x, y, direction)) {
			Board newBoard = new Board(board);
			newBoard.move(x, y, direction);
			Stack<Movement> subSolution = solve(newBoard);
			if(foundSolution(subSolution)) {
				Movement movement = new Movement(x, y, direction);
				solution = new Stack<Movement>();
				solution.push(movement);
				solution.addAll(subSolution);
			}
		}
		return solution;
	}
}
