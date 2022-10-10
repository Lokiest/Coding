package day10;

import javax.swing.*;
import java.awt.*;


public class ImagePanel extends JPanel {
	
	Image img;
	int x = 135;
	int y = 50;
	
	public ImagePanel() {
		this.setBackground(Color.white);
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	public Image getImg() {
		return img;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if(img!=null) {
			g.drawImage(img, x, y, this);
		}
	}
}
