package day06;

import javax.swing.*;
import java.awt.*;

public class MyGUI extends JFrame {
	JButton b1, b2, b3, b4;
	Container cp;
	Icon icon1, icon2, icon3;
	
	JTextField tf1;
	JTextArea ta1;
	JCheckBox c1,c2,c3;
	JRadioButton r1, r2;
	
	public MyGUI() {
		super(":::MyGUI 1.1:::");
		//내용문을 붙일 수 있는 일종의 패널
		cp = this.getContentPane();
		icon1 = new ImageIcon("image/1.png");
		icon2 = new ImageIcon("image/2.png");
		icon3 = new ImageIcon("image/3.png");

		
		b1 = new JButton("Home");
		b2 = new JButton(icon1);
		b3 = new JButton("로그인", icon2);
		b4 = new JButton("Help");
		
		b2.setBackground(Color.white);
		b2.setOpaque(false);
		
		b3.setForeground(Color.blue);
		b2.setHorizontalTextPosition(JButton.CENTER);
		b2.setVerticalTextPosition(JButton.CENTER);
		b3.setPressedIcon(icon3);
		//레이아웃 설정
		//컴텐트페인의 디폴트 레이아웃 : BorderLayout(동 서 남 북 중앙)
		
		cp.setLayout(new FlowLayout());
		
		//버튼 붙이기
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);
		
		tf1 = new JTextField("네이버 검색", 40);
		cp.add(tf1);
		
		ta1 = new JTextArea("Hi",7, 40);
		//스크롤바 생성
		JScrollPane sp = new JScrollPane(ta1);
		cp.add(sp);
		
		c1 = new JCheckBox("Java");
		c2 = new JCheckBox("HTML", true);
		c3 = new JCheckBox("CSS", icon1, true);
		
		cp.add(c1);
		cp.add(c2);
		cp.add(c3);
		
		r1 = new JRadioButton("man");
		r2 = new JRadioButton("woman", true);
		cp.add(r1);
		cp.add(r2);
		//단일 선택이 되게하려면 ButtonGroup객체 생성하고 이 객체에 라디오 버튼을 추가해야
		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		r1.setToolTipText("~");
		r2.setToolTipText("~~");
		
		//창닫기 처리 메소드
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyGUI my = new MyGUI(); //Jframe은 사이즈 지정하고, setvisible 설정해줘야 확인 가능
		my.setSize(500,500);
		my.setVisible(true);

	}

}
