package day10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//이벤트 핸들러 : MouseListener

public class MouseHandler implements MouseMotionListener, ActionListener {
	
	MyPaint my;
	
	public MouseHandler(MyPaint my) {
		this.my = my;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==my.bt[0]) {
			my.can.cr=Color.red;
		}else if(o==my.bt[1]) {
			my.can.cr=Color.green;
		}else if(o==my.bt[2]) {
			my.can.cr=Color.blue;
		}else if(o==my.bt[3]) {
			my.can.w+=2;
			my.can.h+=2;		
		}else if(o==my.bt[4]) {
			my.can.w-=2;
			my.can.h-=2;
		}else if(o==my.bt[5]) {
			my.can.cr=Color.white;
			my.can.w=20;
			my.can.h=20;
		}else if(o==my.bt[6]) {
			Graphics g =my.can.getGraphics();
			g.clearRect(0, 0, my.can.getWidth(), my.can.getHeight());
		}
		
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
//		my.setTitle("~~~~~~~~~~~~");
		//마우스로 드래그한 지점의 좌표를 알아내서 MyCanvas의 좌표로 전달
		int x = e.getX();
		int y = e.getY();
		my.setTitle("x : " + x + "y : " + y);
		
		my.can.x = x;
		my.can.y = y;
		
		//전달된 좌표가 적용되려면 캔버스를 다시 그려야함
		my.can.repaint();
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
//		my.setTitle("~~~~~~~~~~~~");
	}
	
}
