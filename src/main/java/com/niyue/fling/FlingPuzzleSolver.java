package com.niyue.fling;

import java.util.Stack;
import static com.niyue.fling.Direction.*;

public class FlingPuzzleSolver {
	public Stack<Movement> solve(Board board) {
		Stack<Movement> solution = new Stack<Movement>();
		if(!board.isSolved()) {
			for(int x=0;x<Board.DEFAULT_WIDTH;x++) {
				for(int y=0;y<Board.DEFAULT_HEIGHT;y++) {
					if(board.isMovable(x, y, UP)) {
						Board beforeMoveBoard = new Board(board);
						board.move(x, y, UP);
						Stack<Movement> subSolution = solve(board);
						if(subSolution != null) {
							Movement movement = new Movement(x, y, UP);
							solution.push(movement);
							solution.addAll(subSolution);
							return solution;
						}
						else {
							board = beforeMoveBoard;
						}
					}
					if(board.isMovable(x, y, DOWN)) {
						Board beforeMoveBoard = new Board(board);
						board.move(x, y, DOWN);
						Stack<Movement> subSolution = solve(board);
						if(subSolution != null) {
							Movement movement = new Movement(x, y, DOWN);
							solution.push(movement);
							solution.addAll(subSolution);
							return solution;
						}
						else {
							board = beforeMoveBoard;
						}
					}
					if(board.isMovable(x, y, LEFT)) {
						Board beforeMoveBoard = new Board(board);
						board.move(x, y, LEFT);
						Stack<Movement> subSolution = solve(board);
						if(subSolution != null) {
							Movement movement = new Movement(x, y, LEFT);
							solution.push(movement);
							solution.addAll(subSolution);
							return solution;
						}
						else {
							board = beforeMoveBoard;
						}
					}
					if(board.isMovable(x, y, RIGHT)) {
						Board beforeMoveBoard = new Board(board);
						board.move(x, y, RIGHT);
						Stack<Movement> subSolution = solve(board);
						if(subSolution != null) {
							Movement movement = new Movement(x, y, RIGHT);
							solution.push(movement);
							solution.addAll(subSolution);
							return solution;
						}
						else {
							board = beforeMoveBoard;
						}
					}
				}
			}
			solution = null;
		}
		return solution;
	}
}
