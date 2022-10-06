package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDemo extends JFrame {

	Container cp;
	JPanel rootP = new JPanel();
	public MyDemo() {
		super(" -- MyDemo -- ");
		cp = this.getContentPane();
		cp.add(rootP);
		rootP.setBackground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		MyDemo my = new MyDemo();
		my.setBounds(1000, 100, 500, 500);
		my.setVisible(true);

	}

}
