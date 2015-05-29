package fr.snake.game;

import java.awt.Color;

public class SnakePart extends Element {

	public SnakePart(Position position) {
		super(position, Color.WHITE);
	}
	
	public String toString(){
		return "SnakePart : " + super.toString();
	}

}
