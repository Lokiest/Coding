package day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Animation extends JFrame {

	Container cp;
	JPanel rootP = new JPanel();

	public Animation() {
		super(" -- Animation -- ");
		cp = this.getContentPane();
		cp.add(rootP);
		rootP.setBackground(Color.white);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		Animation my = new Animation();
		my.setBounds(1000, 100, 500, 500);
		my.setVisible(true);

	}

}
