package day07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mycalc extends JFrame implements ActionListener {
	
	Container cp;
	JPanel p = new JPanel();
	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JButton btPlus, btReset;

	public mycalc() {
		super("-----mycalc-----");
		cp = this.getContentPane();
		cp.add(p);
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(4,2,10,10));
		
		l1 = new JLabel("정수 1 : ", JLabel.CENTER);
		l2 = new JLabel("정수 2 : ", JLabel.CENTER);
		l3 = new JLabel("결과 : ", JLabel.CENTER);
		
		tf1 = new JTextField(20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		
		btPlus = new JButton("Plus");
		btReset = new JButton("Reset");
		
		p.add(l1); p.add(tf1);
		p.add(l2); p.add(tf2);
		p.add(l3); p.add(tf3);
		p.add(btPlus); p.add(btReset);
		
		this.setBackground(Color.white);
		
		tf3.setEditable(false);
		btPlus.addActionListener(this);
		btReset.addActionListener(this);
		
		setSize(300,300);
		setLocation(500, 500);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void clearTf() {
		tf1.setText(null);
		tf2.setText(null);
		tf3.setText(null);
		tf1.requestFocus(); //입력포커스 주기
	}
	
	public void calc() {
		String n1 = tf1.getText();
		String n2 = tf2.getText();
		String rs="";
		try {
			int result = Integer.parseInt(n1) + Integer.parseInt(n2);
			rs = Integer.toString(result);
			
			tf3.setText(rs);
		} catch (NumberFormatException w) {
//			tf3.setText("정수만 입력");
			JOptionPane.showMessageDialog(p, "정수만 입력");
			clearTf();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btPlus) {
			calc();
		} else {
			clearTf();
		}
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(40,15,15,15);
	}

	public static void main(String[] args) {
		new mycalc();

	}

}
