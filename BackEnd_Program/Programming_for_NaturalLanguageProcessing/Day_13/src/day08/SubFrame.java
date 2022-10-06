package day08;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SubFrame extends JFrame{
	
	JTextField tfR, tfG, tfB;
	JButton btApply, btClose;
	Container cp; //ctrl + shift + O >> 자동 import
	JPanel p = new JPanel();
	
	public SubFrame() {
		super(" -- SubFrame -- ");
		cp = this.getContentPane();
		cp.setLayout(new GridLayout(0,1,10,10)); //1열 고정, 행 가변
		
		cp.add(tfR = new JTextField());
		cp.add(tfG = new JTextField());
		cp.add(tfB = new JTextField());
		cp.add(p);
		
		p.add(btApply = new JButton("Apply"));
		p.add(btClose = new JButton("Close"));
		
		tfR.setBorder(new TitledBorder("RED"));
		tfG.setBorder(new TitledBorder("GREEN"));
		tfB.setBorder(new TitledBorder("BLUE"));
		
		
		this.setBackground(Color.white);
		setSize(200,300);
		
	}

}
