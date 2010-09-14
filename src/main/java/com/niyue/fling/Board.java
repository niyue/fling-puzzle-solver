package com.niyue.fling;

import java.util.Arrays;


public class Board {
	public static final int DEFAULT_WIDTH = 7;
	public static final int DEFAULT_HEIGHT = 8;
	public Board(boolean[][] status) {
		this.status = status;
	}
	
	public Board(Board board) {
		this.status = new boolean[DEFAULT_HEIGHT][DEFAULT_WIDTH];
		for(int y=0;y<DEFAULT_HEIGHT;y++) {
			this.status[y] = Arrays.copyOf(board.getStatus()[y], DEFAULT_WIDTH);
		}
	}
	
	// the origin is located in the left upper corner of the board
	private boolean[][] status;
	
	public boolean[][] getStatus() {
		return status;
	}
	
	public boolean hasFurball(int x, int y) {
		return status[y][x];
	}
	
	public boolean isSolved() {
		int balls = 0;
		for(int x=0;x<DEFAULT_WIDTH;x++) {
			for(int y=0;y<DEFAULT_HEIGHT;y++) {
				if(status[y][x]) {
					balls++;
				}
			}
		}
		return balls == 1;
	}
	
	public void move(int x, int y, Direction direction) {
		Position p = getNearestRemoteFurball(x, y, direction);
		// no nearest remote furball found
		if(p.isValid()) {
			removeBall(x, y);
			Position newPosition = null;
			switch(direction) {
				case UP:
					newPosition = new Position(p.getX(), p.getY() + 1);
					break;
				case DOWN:
					newPosition = new Position(p.getX(), p.getY() - 1);
					break;
				case LEFT:
					newPosition = new Position(p.getX() + 1, p.getY());
					break;
				case RIGHT:
					newPosition = new Position(p.getX() - 1, p.getY());
					break;
			}
			placeBall(newPosition.getX(), newPosition.getY());
			move(p.getX(), p.getY(), direction);
		}
		else {
			removeBall(x, y);
		}
	}
	
	private void removeBall(int x, int y) {
		status[y][x] = false;
	}
	
	private void placeBall(int x, int y) {
		status[y][x] = true;
	}
	
	public boolean isMovable(int x, int y, Direction direction) {
		return hasFurball(x, y) && !hasNeighbor(x, y, direction) && hasRemoteFurball(x, y, direction);
	}
	
	public boolean hasNeighbor(int x, int y, Direction direction) {
		boolean hasNeighbor = false;
		switch(direction) {
			case UP:
				if(y > 0)
					hasNeighbor = status[y-1][x];
				break;
			case DOWN:
				if(y < DEFAULT_HEIGHT - 1)
					hasNeighbor = status[y+1][x];
				break;
			case LEFT:
				if(x > 0)
					hasNeighbor = status[y][x-1];
				break;
			case RIGHT:
				if(x < DEFAULT_WIDTH - 1)
					hasNeighbor = status[y][x+1];
				break;
			default:
				// false
		}
		return hasNeighbor;
	}
	
	public boolean hasRemoteFurball(int x, int y, Direction direction) {
		Position p = getNearestRemoteFurball(x, y, direction);
		return p.isValid();
	}
	
	public Position getNearestRemoteFurball(int x, int y, Direction direction) {
		Position p = new Position(-1, -1);
		switch(direction) {
		case UP:
			for(int row = y - 1; row >= 0; row--) {
				if(status[row][x]) {
					p = new Position(x, row);
					break;
				}
			}
			break;
		case DOWN:
			for(int row = y + 1; row < DEFAULT_HEIGHT; row++) {
				if(status[row][x]) {
					p = new Position(x, row);
					break;
				}
			}
			break;
		case LEFT:
			for(int column = x - 1; column >= 0; column--) {
				if(status[y][column]) {
					p = new Position(column, y);
					break;
				}
			}
			break;
		case RIGHT:
			for(int column = x + 1; column < DEFAULT_WIDTH; column++) {
				if(status[y][column]) {
					p = new Position(column, y);
					break;
				}
			}
			break;
		default:
			// (-1, -1) means there's no nearest remote furball available
		}
		return p;
	}

	@Override
	public String toString() {
		String board = "";
		for(int y=0;y<DEFAULT_HEIGHT;y++) {
			for(int x=0;x<DEFAULT_WIDTH;x++) {
				if(status[y][x]) {
					board += "FBALL ";
				}
				else {
					board += "false ";
				}
			}
			board += "\n";
		}
		return board;
	}
}
