package day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPaint extends JFrame {

	Container cp;
	JPanel pN = new JPanel();
	JPanel rootP = new JPanel();
	JButton bt[] = new JButton[7];
	String label[] = {"RED", "GREEN", "BLUE", "Plus", "Minus", "Eraser", "Clear"};
	MyCanvas can = new MyCanvas();

	public MyPaint() {
		super(" -- MyPaint -- ");
		cp = this.getContentPane();
		cp.add(rootP, BorderLayout.CENTER);
		cp.add(pN, BorderLayout.NORTH);
		
		rootP.setBackground(Color.DARK_GRAY);
		can.setSize(500,400);
		can.setBackground(Color.white);
		rootP.add(can);
		
		MouseHandler handler = new MouseHandler(this);
		
		for(int i = 0;i<bt.length;i++) {
			bt[i] = new JButton(label[i]);
			pN.add(bt[i]);
			bt[i].addActionListener(handler);
		}
		
		//리스너 부착
		
		can.addMouseMotionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		MyPaint my = new MyPaint();
		my.setBounds(1200, 100, 550, 500);
		my.setVisible(true);
		
		

	}

}
