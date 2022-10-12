package my.app2;

import java.awt.*;
import javax.swing.*;

public class MyUserPanel extends JPanel {

	JPanel pN=new JPanel();
	JTextArea ta=new JTextArea();
	JTextField tfKeyword;
	JButton btFind, btAll;
	public MyUserPanel() {
		setLayout(new BorderLayout());
		this.add(pN, BorderLayout.NORTH);
		this.add(new JScrollPane(ta), BorderLayout.CENTER);
		
		tfKeyword=new JTextField(20);
		btFind=new JButton("Search");
		pN.add(tfKeyword);
		pN.add(btFind);
		pN.add(btAll=new JButton("All Users"));
		pN.setBackground(Color.DARK_GRAY);
		
	}

}//////////////////////////////
