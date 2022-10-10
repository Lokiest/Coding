package day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyAnimation extends JFrame {

	Container cp;
	JPanel rootP = new JPanel();
	ImagePanel imgP;
	JButton btStart, btStop;
	Toolkit toolkit;
	Image img;
	MyThread tr;
	boolean isStop = false;

	public MyAnimation() {
		super(" -- MyAnimation -- ");
		toolkit = Toolkit.getDefaultToolkit();
		img = toolkit.getImage("image/T0.gif");
		//이미지를 메모리에 적재
		
		imgP = new ImagePanel();
		imgP.setImg(img);
		
		cp = this.getContentPane();
		cp.add(rootP, BorderLayout.NORTH);
		cp.add(imgP, BorderLayout.CENTER);
		
		rootP.add(btStart=new JButton("START"));
		rootP.add(btStop=new JButton("STOP"));
		
		
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStop = false;
				tr = new MyThread();
				tr.start();
			}
		});
		
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				tr.stop(); 비추
				//자연스럽게 run을 멈추도록 구현해야
				tr.interrupt();
				//InterruptElxception 발생
				
			}
		});
		
		rootP.setBackground(Color.white);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyThread extends Thread {
		public void run() {
			int i = 0;
			while (!isStop) {
				i %= 10;
				img = toolkit.getImage("image/T"+i+".gif");
				i++;
				imgP.setImg(img);
				imgP.repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(e);
					break;
				}
			}
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		MyThread my = new MyThread();
//		if (o == btStart) {
//			my.start();
//		}
//	}

	
	public static void main(String[] args) {

		MyAnimation my = new MyAnimation();
		my.setBounds(1000, 100, 500, 500);
		my.setVisible(true);

	}

}
