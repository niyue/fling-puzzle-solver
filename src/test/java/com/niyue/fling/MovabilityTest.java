package com.niyue.fling;

import junit.framework.TestCase; 
import static com.niyue.fling.Direction.*;

public class MovabilityTest extends TestCase {
	private Board board;
	private static final boolean FBALL = true;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board(new boolean[][] {
			{false, false, false, false, false, false, false},
			{false, false, false, FBALL, false, false, false},	
			{false, false, false, FBALL, false, false, FBALL},	
			{false, false, false, false, false, false, false},	
			{false, false, false, false, false, false, false},	
			{false, false, false, false, false, false, false},	
			{false, false, false, FBALL, false, false, false},	
			{false, false, false, false, false, false, false}
		});
	}

	public void testHasNeighbor() throws Exception {
		assertTrue("(3,1) and (3,2) should be neightbors.", board.hasNeighbor(3, 1, DOWN));
	}
	
	public void testHasNeighborRightMostColumn() throws Exception {
		assertFalse("The right most column should not have right neighbor.", board.hasNeighbor(6, 2, RIGHT));
	}
	
	public void testHasRemoteFurball() throws Exception {
		assertTrue(board.hasRemoteFurball(3, 2, RIGHT));
		assertTrue(board.hasRemoteFurball(3, 2, DOWN));
	}
	
	public void testDoNotHaveRemoteFurball() throws Exception {
		assertFalse(board.hasRemoteFurball(3, 1, UP));
		assertFalse(board.hasRemoteFurball(6, 2, RIGHT));
	}
	
	public void testMovable() throws Exception {
		assertTrue(board.isMovable(6, 2, LEFT));
		assertTrue(board.isMovable(3, 6, UP));
	}
	
	public void testUnmovable() throws Exception {
		assertFalse(board.isMovable(3, 1, DOWN));
		assertFalse(board.isMovable(3, 2, UP));
		assertFalse(board.isMovable(6, 2, RIGHT));
	}
	
	public void testNearestRemoteFurball() throws Exception {
		Position p = board.getNearestRemoteFurball(6, 2, LEFT);
		assertEquals(new Position(3, 2), p);
		p = board.getNearestRemoteFurball(3, 6, UP);
		assertEquals(new Position(3, 2), p);
	}
	
	public void testMoveFurball() throws Exception {
		board.move(6, 2, LEFT);
		assertFalse(board.hasFurball(6, 2));
		assertTrue(board.hasFurball(4, 2));
	}
	
	public void testMoveFurballContinuously() throws Exception {
		board.move(3, 6, UP);
		assertFalse(board.hasFurball(3, 6));
		assertTrue(board.hasFurball(3, 3));
		assertTrue(board.hasFurball(3, 2));
		assertFalse(board.hasFurball(3, 1));
	}
}
