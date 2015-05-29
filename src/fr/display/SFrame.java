package fr.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class SFrame extends JFrame {

	private BufferedImage image;
	private SMap map;
	private fr.display.AffichagePanel panel;
	
	public SFrame(String titre, SMap map){
		super(titre);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.panel = new AffichagePanel();
		this.setContentPane(this.panel);
		this.map = map;
		this.setBackground(Color.black);
		this.setVisible(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			      map.reactTo(e);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void afficher() {
		this.emptyPetri();
		this.drawAllGraphicalElement();
		this.panel.setImage(image);
		this.panel.repaint();
	}
	
	private void emptyPetri() {
		this.image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = this.image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawGraphicalElement(final GraphicalElement gElement, final Graphics g) {
		g.setColor(gElement.getColor());
//		System.out.println("Try to display in X1 ="
//				+ (float)gElement.getPosition().getX()/this.map.getWidth()
//				+ ", Y1 = "
//				+ calcY(gElement.getPosition().getY())
//				+ ", X2 = "
//				+ calcX(1)
//				+ "\nthe element is "
//				+ gElement.toString());
		g.fillRect(calcX(gElement.getPosition().getX()), calcY(gElement.getPosition().getY()), calcX(1), calcY(1));
	}

	public void drawAllGraphicalElement() {
		Graphics g = this.image.getGraphics();
		for (GraphicalElement gElement : map.getGraphicalElementList()) {
			this.drawGraphicalElement(gElement, g);
		}
	}
	
	private int calcX(float x){
		return (int)Math.ceil(this.getContentPane().getWidth()*(x/this.map.getWidth()));
		
	}
	
	private int calcY(float y){
		return (int)Math.ceil(this.getContentPane().getWidth()*(y/this.map.getHeight()));
	}
	
}
