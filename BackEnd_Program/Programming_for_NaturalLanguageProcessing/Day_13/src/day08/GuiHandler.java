package day08;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

//이벤트 핸들러를 외부로 작성하는 경우
/*- 인자 생성자를 구성해서 같이 연동할 객체를 전달받는다
* - 멤버변수에 전달하고
* - 멤버변수로 핸들링한다
* */
//MyGui의 open 누르면 SubFrame 보이기
public class GuiHandler implements ActionListener{
	
	MyGui3 mainF;
	
	public GuiHandler(MyGui3 mg3) {
		this.mainF = mg3;
	}
	
	public void showMsg(String msg) {
		
		JOptionPane.showMessageDialog(mainF, msg);
		
	}
	
	public void cleartf() {
		mainF.sf.tfR.setText(null);
		mainF.sf.tfG.setText(null);
		mainF.sf.tfB.setText(null);
		mainF.sf.tfR.requestFocus();
	}
	
	private void applyColor() {
		try {
			int r = Integer.parseInt(mainF.sf.tfR.getText());
			int g = Integer.parseInt(mainF.sf.tfG.getText());
			int b = Integer.parseInt(mainF.sf.tfB.getText());
		
		
			Color cr = new Color(r,g,b);
			mainF.can.setBackground(cr);
		} catch (NumberFormatException e) {
			showMsg("0 ~ 255 사이 정수 입력");
			cleartf();
		} catch (IllegalArgumentException e) {
			showMsg("0 ~ 255 사이 정수 입력");
			cleartf();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
//		SubFrame sf = new SubFrame();
//		sf.setVisible(true);
		
		Object o = e.getSource();
		if (o == mainF.btOpen) {
			mainF.sf.setLocation(mainF.getLocation().x + mainF.getSize().width, mainF.getLocation().y);
			mainF.sf.setVisible(true);
		} else if (o == mainF.btExit) {
			System.exit(0);
		} else if (o == mainF.sf.btApply) {
			applyColor();
		} else if (o == mainF.sf.btClose) {
//			System.exit(0);
			mainF.sf.setVisible(false);
			mainF.sf.dispose();
		}
		
	}
}
