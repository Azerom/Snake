package fr.snake.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import fr.display.GraphicalElement;
import fr.display.SMap;

public class Map implements SMap {
	private int width;
	private int height;
	
	private Snake snake = null;
	private Food food = null;
	
	private ArrayList<KeyEvent> keysBuffer;
	
	public Map(int width, int height){
		this.width = width;
		this.height = height;
		this.snake = new Snake(this);
		this.food = new Food(this);
		this.keysBuffer = new ArrayList<KeyEvent>();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	public boolean isEmpty(Position position){
		return true;
	}
	
	public Position getRandomEmptyPosition(){
		Random random = new Random();
		Position position = new Position(random.nextInt(this.getWidth()), random.nextInt(this.getHeight()));

		return position;
	}
	
	public boolean own(Position position){
		if(position.getX() >= 0 && position.getX() < this.width 
				&& position.getY() >= 0 && position.getY() < this.height)
			return true;
		else
			return false;
			
	}

	@Override
	public ArrayList<GraphicalElement> getGraphicalElementList() {
		ArrayList<GraphicalElement> list = new ArrayList<GraphicalElement>();
		list.addAll(snake);
		list.add(food);
		return list;
	}

	@Override
	public void reactTo(KeyEvent e) {
		keysBuffer.add(e);
		
	}
	
	private void keyManagement(){
		Iterator<KeyEvent> it = keysBuffer.iterator();
		if(it.hasNext()){
			switch(it.next().getKeyChar()){
				case 'z':
					this.snake.turn(Snake.NORTH);
					break;
				case 'd':
					this.snake.turn(Snake.EAST);
					break;
				case 's' :
					this.snake.turn(Snake.SOUTH);
					break;
				case 'q' :
					this.snake.turn(Snake.WEST);
					break;
			}
			it.remove();
		}
	}
	
	public void turn(){
//		System.out.println(this.getSnake().toString());
		this.getSnake().move();
		keyManagement();
	}
	
	public void reset(){
		this.snake = new Snake(this);
		this.food = new Food(this);
		this.keysBuffer = new ArrayList<KeyEvent>();
	}
	
}
