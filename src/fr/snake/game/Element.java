package fr.snake.game;

import java.awt.Color;

import fr.display.GraphicalElement;

public class Element implements GraphicalElement{
	protected Position position;
	protected Color color;
	
	public Element(Position position, Color color){
		this.position = position;
		this.color = color;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString(){
		return "X = "
				+ position.getX()
				+ ", Y = "
				+ position.getY();
	}
	
}
