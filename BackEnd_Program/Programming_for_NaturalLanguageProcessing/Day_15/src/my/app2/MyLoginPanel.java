package my.app2;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyLoginPanel extends JPanel {
	JTextField tfName;
	JPasswordField tfPwd;
	JButton btnLogin;
	//x,y좌표 지정해서 붙이려면 기본레이아웃을 해제해야 한다.
	//대신 컴포넌트의 사이즈와 x,y좌표를 수동으로 지정해야 한다
	public MyLoginPanel() {
		this.setLayout(null);
		tfName=new JTextField(20);
		tfPwd=new JPasswordField(20);
		btnLogin=new JButton("Login");
		tfName.setSize(200,50);//w,h
		tfName.setLocation(90, 100);//x,y
		tfPwd.setBounds(90,170, 200,50);
					//x,y w, h
		btnLogin.setBounds(90,240,200,50);
		btnLogin.setBackground(new Color(123,123,200));//r,g,b
		btnLogin.setBorder(new LineBorder(Color.gray,3));
		
		tfName.setBorder(new TitledBorder("Name"));
		tfPwd.setBorder(new TitledBorder("Password"));
		
		this.add(tfName);
		this.add(tfPwd);
		this.add(btnLogin);
	}
}
