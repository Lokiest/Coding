package day07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGui extends JFrame {
	
	Container cp;
	JPanel p1, p2;
	CardLayout card;
	
	public PongGui() {
		cp = this.getContentPane();
		cp.setLayout(card = new CardLayout()); //카드 레이아웃 설정
		p1 = new MyLoginPanel();
		p2 = new JPanel();
		
		cp.add(p1, "Log in");
		cp.add(p2, "Home");
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
//		card.show(cp, "Home");
//		p1.btnLogin.addActionListener(this);
		
		this.setSize(400, 600);
		this.setLocation(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new PongGui();

	}

}
