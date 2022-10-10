package day10;

import java.awt.*;

public class MyCanvas extends Canvas {
	
	int x = -50;
	int y = -50;
	Color cr = Color.cyan;
	int w = 7;
	int h = 7;
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(cr);
		g.fillOval(x, y, w, h);
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
}
