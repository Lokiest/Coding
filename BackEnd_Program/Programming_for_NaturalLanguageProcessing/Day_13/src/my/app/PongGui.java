package my.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGui extends JFrame{

	Container cp;
	JPanel p2;
	MyLoginPanel p1;
	MyJoinPanel p3;
	CardLayout card;
	
	
	public PongGui() {
		cp=this.getContentPane();//default=> BorderLayout
		cp.setLayout(card=new CardLayout());//카드레이아웃 설정
		p1=new MyLoginPanel();
		p2=new JPanel();
		
		p3=new MyJoinPanel();
		
		cp.add(p1,"login");
		cp.add(p2,"home");
		cp.add(p3,"join");
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		//card.show(cp,"home");
		//p1.btnLogin.addActionListener(this);
		MyHandler handler=new MyHandler();
		p1.btnLogin.addActionListener(handler);
		
		this.setSize(400,600);
		this.setLocation(1000,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//--------------------------------
	
	private void login() 
	throws NotSupportedNameException, Exception
	{
		String name=p1.tfName.getText();
		char[] pwd=p1.tfPwd.getPassword();
		String strPwd=new String(pwd);
		System.out.println(name+"/"+strPwd);
		
		if(name.startsWith("퐁")) {
			card.show(cp, "home");
		}else if(name.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 절대로 이용 불가!!");
		}else {
			throw new Exception("기타 성씨는 이용에 제한이 있어요");
		}
	}//----------------------------------
	
	class MyHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 		
		{
			Object o=e.getSource();
			if(o==p1.btnLogin) {
				try {
					login();
				}catch(NotSupportedNameException ex) {
					JOptionPane.showMessageDialog(p1, ex.getMessage(),"경고", JOptionPane.WARNING_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(p1, ex.getMessage(),"경고", JOptionPane.PLAIN_MESSAGE);
					card.show(cp, "join");
				}
			}
		}
	}///////////////////////
	

	public static void main(String[] args) {
		new PongGui();
	}

}
