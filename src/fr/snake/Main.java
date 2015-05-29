package fr.snake;

import fr.display.SFrame;
import fr.snake.game.Map;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(50,50);
		
		SFrame display = new SFrame("Snake", map);
		
		while(true){
			display.afficher();

			map.turn();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		

	}

}
