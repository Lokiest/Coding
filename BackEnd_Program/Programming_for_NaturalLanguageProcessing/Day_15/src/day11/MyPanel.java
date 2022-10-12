package day11;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyPanel extends JPanel{
	
	int x = 50, y = 130, w = 70, h = 70;
	Color cr = Color.cyan;
	
	public MyPanel() {
		Random ran = new Random();
		int r = ran.nextInt(256) + 0; //0~256
		int g = ran.nextInt(256) + 0; //0~256
		int b = ran.nextInt(256) + 0; //0~256
		cr = new Color(r,g,b);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(cr);
		g.fillOval(x, y, w, h);
	}

}
