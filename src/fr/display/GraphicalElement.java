package fr.display;

import java.awt.Color;

import fr.snake.game.Position;

public interface GraphicalElement {
	
	public Position getPosition() ;
	public void setPosition(Position position);
	public Color getColor() ;
	public void setColor(Color color);
	
	public String toString();
		
}
