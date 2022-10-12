package my.app2;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
public class MyJoinPanel extends JPanel {
	
	JTextField tfName, tfTel;
	JPasswordField tfPwd;
	JButton btJoin, btReset;
	JLabel lb;
	public MyJoinPanel() {
		this.setBackground(Color.cyan);
		this.setLayout(null);
		tfName=new JTextField();
		tfTel=new JTextField(20);
		tfPwd=new JPasswordField(20);
		
		btJoin=new JButton("Join");
		btReset=new JButton("Reset");
		lb=new JLabel("회원 가입", JLabel.CENTER);
		lb.setFont(new Font("궁서체",Font.BOLD,22));//서체 적용
		
		lb.setBounds(90, 30,200,40);
		tfName.setBounds(90,100,200,50);//x,y,w,h
		tfPwd.setBounds(90,170,200,50);
		tfTel.setBounds(90,240,200,50);
		
		btJoin.setBounds(90,320,80,50);
		btReset.setBounds(190,320,80,50);
		
		tfName.setBorder(new TitledBorder("Name"));
		tfPwd.setBorder(new TitledBorder("Password"));
		tfTel.setBorder(new TitledBorder("Tel"));
		
		this.add(lb);
		this.add(tfName);
		this.add(tfPwd);
		this.add(tfTel);
		this.add(btJoin);
		this.add(btReset);
	}
	public void clearTf() {
		tfName.setText(null);
		tfPwd.setText(null);
		tfTel.setText(null);
		tfName.requestFocus();
	}
	
	

}
