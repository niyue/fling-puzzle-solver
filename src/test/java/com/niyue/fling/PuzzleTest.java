package com.niyue.fling;

import java.util.Stack;

import junit.framework.TestCase;

public class PuzzleTest extends TestCase {
	private static final boolean FBALL = true;
	
	public void testTwoBalls() throws Exception {
		Board board = new Board(new boolean[][] {
				{FBALL, false, false, false, false, FBALL, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false}
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(1, solution.size());
		print(solution);
	}
	
	public void testThreeBalls() throws Exception {
		Board board = new Board(new boolean[][] {
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, FBALL, false, false, FBALL},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, FBALL, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false}
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(2, solution.size());
		print(solution);
	}
	

	public void testFourBalls() throws Exception {
		Board board = new Board(new boolean[][] {
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, FBALL, false, false, FBALL},	
				{false, FBALL, false, false, false, false, false},	
				{false, false, false, false, false, FBALL, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false}
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(3, solution.size());
		print(solution);
	}
	
	public void testFourBallsII() throws Exception {
		Board board = new Board(new boolean[][] {
				{FBALL, false, false, FBALL, false, FBALL, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, FBALL, false, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false}	
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(3, solution.size());
		print(solution);
	}
	
	public void testReal() throws Exception {
		Board board = new Board(new boolean[][] {
				{false, false, false, false, false, false, FBALL},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, FBALL, false, false, false, false},	
				{false, false, FBALL, false, false, false, FBALL},
				{false, false, false, false, FBALL, FBALL, false},	
				{FBALL, false, false, FBALL, false, FBALL, false}	
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(8, solution.size());
		print(solution);
	}
	
	public void testRealII() throws Exception {
		Board board = new Board(new boolean[][] {
				{false, false, false, false, FBALL, false, false},
				{FBALL, false, false, false, FBALL, FBALL, FBALL},
				{false, false, false, false, false, FBALL, false},	
				{false, false, false, false, false, false, false},	
				{FBALL, false, false, false, FBALL, false, false},	
				{false, false, FBALL, FBALL, false, false, false},
				{false, false, false, FBALL, false, false, false},	
				{false, false, false, false, false, false, false}	
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(10, solution.size());
		print(solution);
	}
	
	public void testRealIII() throws Exception {
		Board board = new Board(new boolean[][] {
				{false, false, false, FBALL, false, false, false},
				{FBALL, false, false, false, false, false, false},
				{false, false, false, FBALL, false, false, false},	
				{false, false, false, false, false, false, false},	
				{false, false, false, false, false, FBALL, false},	
				{FBALL, false, false, FBALL, false, false, false},
				{FBALL, false, false, false, false, false, false},	
				{false, false, false, false, false, false, false}	
		});
		Stack<Movement> solution = new FlingPuzzleSolver().solve(board);
		assertEquals(6, solution.size());
		print(solution);
	}
	private void print(Stack<Movement> solution) {
		System.out.println("====================");
		for(Movement movement : solution) {
			System.out.println(String.format("(%s, %s) %s", movement.getX() + 1, movement.getY() + 1, movement.getDirection()));
		}
	}
}
