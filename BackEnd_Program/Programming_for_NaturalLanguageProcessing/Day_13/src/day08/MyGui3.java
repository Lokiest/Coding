package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGui3 extends JFrame {

	Container cp;
	JPanel rootP = new JPanel();
	
	Canvas can = new Canvas();
	JButton btOpen, btExit;
	SubFrame sf;

	public MyGui3() {
		super(" -- MyGui3 -- ");
		cp = this.getContentPane();
		cp.add(rootP);
		rootP.setBackground(Color.white);
		rootP.add(can);
		can.setSize(150,150);
		can.setBackground(Color.darkGray);
		
		rootP.add(btOpen = new JButton("Open"));
		rootP.add(btExit = new JButton("Exit"));
		sf = new SubFrame();
		
		GuiHandler handler = new GuiHandler(this);
		btOpen.addActionListener(handler);
		btExit.addActionListener(handler);
		
		sf.btApply.addActionListener(handler);
		sf.btClose.addActionListener(handler);
		
		
//		btOpen.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				sf.setVisible(true);
//			}
//		});
		
		this.setResizable(false); //프레임 사이즈 조절 불가능

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		MyGui3 my = new MyGui3();
		my.setBounds(1000, 100, 200, 300);
		my.setVisible(true);

	}

}

