package com.niyue.fling;

public class Movement {
	private int x, y;
	private Direction direction;
	
	public Movement(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Direction getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		return String.format("[Movement](%s, %s) %s", x, y, direction);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movement other = (Movement) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
