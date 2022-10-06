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

public class MyGui2 extends JFrame {

	Container cp;
	JPanel rootP = new JPanel() { //Anonymous class
		@Override
		public Insets getInsets() {
			return new Insets(40, 0, 0, 0);
		}
	};
	JRadioButton r,g,b;
	Canvas can;
	
	public MyGui2() {
		super(" -- MyGui2 -- ");
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
		r.addItemListener(new ItemListener() { //전용 이벤트 핸들러이기 때문에 실수가 적음
			@Override
			public void itemStateChanged(ItemEvent e) {
				can.setBackground(Color.red);
			}
		});
		
		g.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				can.setBackground(Color.green);
			}
		});
		
		b.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				can.setBackground(Color.blue);
			}
		});
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyEventHandler implements ItemListener { //한 번에 몰아넣을 수 있는 장점이 있지만, 실수 가능성 높음
		
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

		MyGui2 my = new MyGui2();
		my.setBounds(1000, 100, 300, 400);
		my.setVisible(true);

	}

}
