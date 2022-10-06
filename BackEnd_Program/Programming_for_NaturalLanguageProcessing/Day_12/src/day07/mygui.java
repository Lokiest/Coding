package day07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // [1]
//window계열 : JFrame > 독립적
//Panel계열 : JPanel > 비독립적

//이벤트 처리 절차
// [1] import java.awt.event.*;
// [2] XXXListener 인터페이스 상속 받기 (ActionListener)
// [3] 추상메소드를 오버라이딩 (빈블럭으로) >> 이벤트 처리 메소드
// [4] 이벤트 소스에 리스너 붙이기 addXXXListener() 메소드 이용
//			>> b1.addActionListener(핸들러 객체)
// [5] 오버라이딩한 메소드에 이벤트 처리코드를 구현

public class mygui extends JFrame implements ActionListener { //[2]
	Container cp; //기본 레아이웃 : borderlayout
	JPanel p; //기본 레이아웃 : flowlayout
	JButton b1, b2, b3;
	
	public mygui() {
		super("::mygui::");
		cp = this.getContentPane();
		
		p = new JPanel();
		cp.add(p);
		p.setBackground(Color.white);
		
		b1 = new JButton("Red", new ImageIcon("image/1.png"));
		b2 = new JButton("Blue", new ImageIcon("image/1.png"));
		b3 = new JButton("Green", new ImageIcon("image/1.png"));
		
		b1.setMnemonic('R');
		b2.setMnemonic('B');
		b3.setMnemonic('G');
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		//리스너 부착 ---
		b1.addActionListener(this); //[4]
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //[3]
		//[5]
		Object obj = e.getSource();
		if (obj == b1) {
			p.setBackground(Color.red);
		} else if (obj == b2) {
			p.setBackground(Color.blue);
		} else {
			p.setBackground(Color.green);
		}
	}

	public static void main(String[] args) {
		mygui my = new mygui();
		my.setSize(500, 500);
		my.setVisible(true);
		

	}

}
