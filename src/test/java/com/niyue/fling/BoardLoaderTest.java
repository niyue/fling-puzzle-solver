package com.niyue.fling;

import junit.framework.TestCase;

public class BoardLoaderTest extends TestCase {
	public void testLoadBoard() throws Exception {
		Board board = BoardLoader.load(getClass().getClassLoader().getResourceAsStream("puzzle.data"));
		assertNotNull(board);
		assertTrue(board.hasFurball(0, 0));
		assertTrue(board.hasFurball(5, 0));
		assertTrue(board.hasFurball(6, 2));
	}
}
