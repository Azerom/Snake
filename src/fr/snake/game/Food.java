package fr.snake.game;

import java.awt.Color;

public class Food extends Element{
	private Map map;
	
	public Food(Map map){
		this(map, map.getRandomEmptyPosition());
	}
	public Food(Map map, Position position){
		super(position, Color.GREEN);
		this.map = map;
	}
	public void respawn(){
		this.setPosition(map.getRandomEmptyPosition());
	}
	
	public String toString(){
		return "Food : " + super.toString();
	}
	

}
