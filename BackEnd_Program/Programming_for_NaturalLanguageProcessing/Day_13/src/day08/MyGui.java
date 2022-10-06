package day08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//JButton, JTextField >> ActionEvent
//JRadioButton >> ItemEvent

/*이벤트핸들러 구성하는 방법
 * [1] 컴포넌트를 가진 클래스가 이벤트핸들러가 되는 방법
 * [2] 이너 클래스로 구성하는 방법
 * 		- 이너 멤버 클래스
 *      - 이름없는 로컬 클래스
 * [3] 외부 클래스로 구성하는 방법
 * */

public class MyGui extends JFrame {

	Container cp;
	JPanel rootP = new JPanel();
	JRadioButton r,g,b;
	Canvas can;
	
	public MyGui() {
		super(" -- MyGui -- ");
		cp = this.getContentPane();
		cp.add(rootP);
		rootP.setBackground(Color.white);
		
		r = new JRadioButton("RED");
		g = new JRadioButton("GREEN", true);
		b = new JRadioButton("BLUE");
		
		rootP.add(r);
		rootP.add(g);
		rootP.add(b);
		r.setBackground(Color.white);
		g.setBackground(Color.white);
		b.setBackground(Color.white);
		
		ButtonGroup group = new ButtonGroup();
		group.add(r); group.add(g); group.add(b); 
		
		can = new Canvas(); //도화지 클래스 : 컴포넌트 > 사이즈 주고 배경색 줘야 확인 가능
		rootP.add(can);
		can.setSize(200,200);
		can.setBackground(Color.green);
		//리스터 부착 ---
		MyEventHandler handler = new MyEventHandler();
		r.addItemListener(handler);
		g.addItemListener(handler);
		b.addItemListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyEventHandler implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
//			setTitle("~~~");
			Object o = e.getItem();
			if (o == r) {
				can.setBackground(Color.red);
			} else if (o == g) {
				can.setBackground(Color.green);
			} else if (o == b) {
				can.setBackground(Color.blue);
			}
		}
	}

	public static void main(String[] args) {

		MyGui my = new MyGui();
		my.setBounds(1000, 100, 300, 400);
		my.setVisible(true);

	}

}
