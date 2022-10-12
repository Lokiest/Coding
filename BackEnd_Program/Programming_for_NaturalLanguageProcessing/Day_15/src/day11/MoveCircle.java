package day11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveCircle extends JFrame implements Runnable {

	Container cp;
	JPanel rootP = new JPanel();
	JButton btStart, btStop;
	MyPanel myP = new MyPanel();
	Thread tr;
	boolean flag = false;

	public MoveCircle() {
		super(" -- MoveCircle -- ");
		cp = this.getContentPane();
		cp.add(rootP, BorderLayout.NORTH);
		cp.add(myP,BorderLayout.CENTER);
		myP.setBackground(Color.white);
		
		rootP.setBackground(Color.white);
		rootP.add(btStart = new JButton("START"));
		rootP.add(btStop = new JButton("STOP"));
		
		btStart.addActionListener(e->{
			flag = true;
			tr = new Thread(this);
			tr.start();
		});
		btStop.addActionListener(e-> {
			flag = false;
			tr.interrupt();
			
		});
		
		
//		btStart.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				MoveCircle r = new MoveCircle();
//				//문법적으로는 맞으나 실제 메모리에 올라간 객체는 다른 객체
//				flag = true;
//				tr = new Thread(MoveCircle.this);
//				tr.start();
//			}
//		});
//		
//		btStop.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				flag = false;
//				tr.interrupt();
//			}
//		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() {
		while(flag) {
			//myP.x 값 증가
			if(myP.x>=myP.getWidth()) {
				myP.x=0;
			}
				myP.x++;
			System.out.println(myP.x);
			//repaint 적용
			myP.repaint();
			//sleep()
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println(e);
				break;
			}
			
		}
	}

	public static void main(String[] args) {

		MoveCircle my = new MoveCircle();
		my.setBounds(1000, 100, 500, 500);
		my.setVisible(true);

	}

}

