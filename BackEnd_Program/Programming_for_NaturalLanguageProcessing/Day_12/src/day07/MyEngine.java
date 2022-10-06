package day07;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyEngine extends JFrame implements ActionListener {

	Container cp;
	JPanel p;
	JButton[] bt;
	String str[] = {"naver", "google", "youtube", "nate"};
	Color origin;
	
	public MyEngine() {
		super("-----MyEngine-----");
		cp = this.getContentPane();
		cp.add(p = new JPanel());
		p.setLayout(new GridLayout(2,2,10,10));
		//2행 2열, 수평 수직 간격 10
		
		//버튼 4개 생성해서 (반복문) p에 부착, 이벤트에 대한 처리
		bt = new JButton[4];
		for (int i =0; i<bt.length;i++) {
//			bt[i] = new JButton(str[i]);
//			p.add(bt[i]);
			p.add(bt[i] = new JButton(str[i]));
			bt[i].addActionListener(this);
		}
		
		origin = bt[0].getBackground();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		setTitle("#####");
		Object o = e.getSource();
		//이벤트가 발생한 객체의 색상
		Color cr = ((JButton)o).getBackground();
		
		if (cr == origin) {
			if (o == bt[0]) {
	//			Color cr2 = (cr != Color.green)? Color.green:null;
	//			bt[0].setBackground(cr2);
				bt[0].setBackground(Color.green);
			} else if (o == bt[1]) {
				bt[1].setBackground(Color.orange);
			} else if (o == bt[2]) {
				bt[2].setBackground(Color.magenta);
			} else if (o == bt[3]) {
				bt[3].setBackground(Color.cyan);
			}
		} else {
			((JButton)o).setBackground(origin);
		}
	}

	//JFrame의 바깥 여백을 주는 메소드 재정의
	@Override
	public Insets getInsets() {
		Insets in = new Insets(40, 20, 20, 20);
		return in;
		
	}
	
	public static void main(String[] args) {
		MyEngine my = new MyEngine();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}
