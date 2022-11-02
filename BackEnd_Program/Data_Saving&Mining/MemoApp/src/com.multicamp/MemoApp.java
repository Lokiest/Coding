package com.multicamp;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 
 * mvc 패턴 >> 웹 mvc 패턴 도입
 * 
 * 모델1 방식 : mvc패턴을 적용하지 않을 때
 * 모델2 방식 : mvc패턴 적용
 * 
 * model : db접근로직 ( 비지니르 로직 crud) [Persistence Layer - 영속성 계층]
 * 			VO, DAO
 * view : 화면단(Presentatioin Layer) - Swing, HTML(JSP)
 * controller: model view 사이에서 제어하는 역할을 담당하는 계층, event handler, servlet/springframework controller
 * 
 * MemoApp:=> GUI /Event처리/View 담당 [Presentatioin Layer]
 * XXXDAO: DB접근 로직(비즈니스 로직을 갖는다. CRUD)
 * 		   Data Access Object  [Persistence Layer-영속성 계층]
 * XXXVO/XXXDTO [Domain Layer]
 *  Value Object/ Data Transfer Object
 * 	: 사용자가 입력한 값을 담거나 DB에서 가져온 값을 갖고 있는
 *    객체
 * 
 * */
public class MemoApp extends JFrame {

	JLabel lb;
	JPanel p = new JPanel(new GridLayout(2, 1));
	JPanel p_1 = new JPanel();
	JPanel p4 = new JPanel();

	JTextArea ta;
	JTextField tfName, tfDate, tfMsg, tfIdx;
	JButton btAdd, btList, btDel, btEdit, btEditEnd, btFind;
	MemoHandler handler;

	public MemoApp() {
		super("::MemoApp::");

		Container cp = this.getContentPane();
		cp.add(p, "North");

		ta = new JTextArea("::한줄 메모장::");
		cp.add(new JScrollPane(ta), "Center");
		ta.setEditable(false);// 편집 못하도록. 읽기 전용

		lb = new JLabel("♥♥한줄 메모장♥♥", JLabel.CENTER);
		p.add(lb);
		lb.setFont(new Font("Serif", Font.BOLD, 28));
		p.add(p_1);

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		p_1.setLayout(new GridLayout(2, 1));
		p_1.add(p2);
		p_1.add(p3);

		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));

		p2.add(new JLabel("작성자: "));
		tfName = new JTextField(12);
		p2.add(tfName);

		p2.add(new JLabel("작성일: "));
		tfDate = new JTextField(12);
		p2.add(tfDate);

		p2.add(new JLabel("글번호: "));
		tfIdx = new JTextField(12);
		p2.add(tfIdx);
		tfIdx.setEditable(false);

		p3.add(new JLabel("메모내용: "));
		tfMsg = new JTextField(40);
		p3.add(tfMsg);

		btAdd = new JButton("등  록");
		btList = new JButton("글목록");
		p3.add(btAdd);
		p3.add(btList);

		tfDate.setEditable(false);
		tfDate.setText("YY-MM-DD");
		tfDate.setFont(new Font("Dialog", Font.BOLD, 14));
		tfDate.setForeground(Color.blue);
		tfDate.setHorizontalAlignment(tfDate.CENTER);

		cp.add(p4, "South");
		btDel = new JButton("글삭제");
		btEdit = new JButton("글수정");
		btEditEnd = new JButton("글수정 처리");
		btFind = new JButton("글검색");

		p4.add(btDel);
		p4.add(btEdit);
		p4.add(btEditEnd);
		p4.add(btFind);
		
		//리스너 부착
		handler = new MemoHandler(this);
		
		btAdd.addActionListener(handler);
		btDel.addActionListener(handler);
		btEdit.addActionListener(handler);
		btEditEnd.addActionListener(handler);
		btFind.addActionListener(handler);
		btList.addActionListener(handler);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setVisible(true);
	}// 생성자-----------

	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str);
	}// ----------------------------

	public static void main(String[] args) {
		new MemoApp();
	}
}
