package fr.display;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public interface SMap {
	public ArrayList<GraphicalElement> getGraphicalElementList();
	
	public int getWidth();
	public int getHeight();

	public void reactTo(KeyEvent e);
}
