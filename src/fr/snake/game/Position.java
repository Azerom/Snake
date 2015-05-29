package fr.snake.game;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void modify(int x, int y){
		this.x = this.x + x;
		this.y = this.y +y;
	}
	
	public boolean equals(Position position){
		if (position.getX() == this.getX() && position.getY() == this.getY())
			return true;
		else
			return false;
	}
}
