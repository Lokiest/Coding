package day07;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MyLoginPanel extends JPanel {
	
	JTextField tfname;
	JPasswordField tfpwd;
	JButton btnLogin;
	
	//x, y좌표 지정해서 붙이려면 기본 레이아웃 해제필요
	//대신 컴포넌트의 사이즈와 x,y좌표 수동으로 지정해줘야 함
	
	public MyLoginPanel() {
		this.setLayout(null);
		
		tfname = new JTextField(20);
		tfpwd = new JPasswordField(20);
		btnLogin = new JButton("Login");
		
		tfname.setSize(300, 50);
		tfname.setLocation(50, 80);
		
		tfpwd.setBounds(50, 150,300,50);
		
		btnLogin.setBounds(50, 240,300,50);
		btnLogin.setBackground(new Color(123,222,222));
		btnLogin.setBorder(new LineBorder(Color.gray,3));
		
		tfname.setBorder(new TitledBorder("Name"));
		tfpwd.setBorder(new TitledBorder("Password"));
		
		this.add(tfname);
		this.add(tfpwd);
		this.add(btnLogin);
		
	}

}
