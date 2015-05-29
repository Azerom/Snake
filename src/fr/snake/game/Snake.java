package fr.snake.game;

import java.util.ArrayList;
import java.util.Iterator;

public class Snake extends ArrayList<SnakePart> {

	private static final long serialVersionUID = 1L;
	public final static int NORTH = 0;
	public final static int EAST = 1;
	public final static int SOUTH = 2;
	public final static int WEST = 3;
	private int direction;
	private Map map;
	
	public Snake(Map map, Position position){
		this.map = map;
		this.add(new SnakePart(position));
		direction = -1;
	}
	
	public Snake(Map map){
		this(map, map.getRandomEmptyPosition());
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		if(direction <= 4 && direction >= 0)
			this.direction = direction;
	}

	public void move(){
		Iterator<SnakePart> it = this.iterator();
		SnakePart snakePart;
		Position position;
		Position positionTemp;
		boolean grow = false;
		int x = 0, y = 0;
		switch (direction){
			case NORTH :
				x = 0;
				y = -1;
				break;
			case EAST :
				x = 1;
				y = 0;
				break;
			case SOUTH :
				x = 0;
				y = 1;
				break;
			case WEST :
				x = -1;
				y = 0;
				break;
		}
		snakePart = it.next();
		position = snakePart.getPosition();
		if(!map.own(position)){
			this.die();
			return;
		}
		if(map.getFood().position.equals(position)){
			grow = true;
			map.getFood().respawn();
		}
			
		snakePart.position = new Position(position.getX() + x, position.getY() + y);	
		while(it.hasNext()){
			snakePart = it.next();
			positionTemp = snakePart.getPosition();
			snakePart.setPosition(position);
			position = positionTemp;
		}
		if(grow){
			this.add(new SnakePart(position));
		}
		
	}
	
	public boolean contain(Position position){
		Iterator<SnakePart> it = this.iterator();
		while(it.hasNext()){
			if(it.next().position.equals(position))
				return true;
		}
		return false;
	}
	public String toString(){
		String toString = "Snake :\n";
		Iterator<SnakePart> it = this.iterator();
		while(it.hasNext()){
			toString += "   "
					+ it.next().toString()
					+ "\n";
		}
		return toString;
	}
	private void die(){
		System.out.println("Score : "
				+ Math.round((this.size()-1)*(2500/(float)(map.getHeight()*map.getWidth()))));
		map.reset();
	}
	public void turn(int i){
		switch(i){
			case NORTH :
				if(this.direction == EAST || this.direction == WEST || this.direction == -1)
					this.direction = NORTH;
				break;
			case EAST :
				if(this.direction == NORTH || this.direction == SOUTH || this.direction == -1)
					this.direction = EAST;
				break;
			case SOUTH :
				if(this.direction == EAST || this.direction == WEST || this.direction == -1)
					this.direction = SOUTH;
				break;
			case WEST :
				if(this.direction == NORTH || this.direction == SOUTH || this.direction == -1)
					this.direction = WEST;
				break;
		}
	}
}
