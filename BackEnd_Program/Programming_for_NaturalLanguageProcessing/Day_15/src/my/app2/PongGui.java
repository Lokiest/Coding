package my.app2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PongGui extends JFrame{

	Container cp;
	JPanel p2;
	MyLoginPanel p1;
	MyJoinPanel p3;
	MyUserPanel p4;
	CardLayout card;
	JPanel p=new JPanel();
	JPanel northP=new JPanel();
	JButton bt[]=new JButton[4];
	String label[]= {"Home","Login","Join","Users"};
	JLabel lbImg;
	MyHandler handler=new MyHandler();
	HashMap<String, Member> usersMap=new HashMap<>();
	public PongGui() {
		cp=this.getContentPane();//default=> BorderLayout
		cp.add(p,BorderLayout.CENTER);
		cp.add(northP, BorderLayout.NORTH);
		p.setLayout(card=new CardLayout());
		//중앙 패널을 카드레이아웃으로 주자
		northP.setLayout(new GridLayout(1,0));
		//1행 고정, 열은 가변적으로
		for(int i=0;i<bt.length;i++) {
			bt[i]=new JButton(label[i]);
			northP.add(bt[i]);
			bt[i].setBackground(Color.white);
			bt[i].addActionListener(handler);
		}
		p1=new MyLoginPanel();
		p2=new JPanel();//Home
		
		p2.setLayout(new BorderLayout());
		lbImg=new JLabel(new ImageIcon("images/bg.jpg"));
		p2.add(lbImg, BorderLayout.CENTER);
		
		p3=new MyJoinPanel();
		p4=new MyUserPanel();
		
		p.add(p1,"login");
		p.add(p2,"home");
		p.add(p3,"join");
		p.add(p4,"users");
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		card.show(p,"home");
		//p1.btnLogin.addActionListener(this);
		
		p1.btnLogin.addActionListener(handler);
		p3.btJoin.addActionListener(handler);
		p3.btReset.addActionListener(handler);
		p4.btAll.addActionListener(handler);
		p4.btFind.addActionListener(handler);
		
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
			card.show(p, "home");
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
			if(o==bt[0]) {//Home Menu
				card.show(p, "home");
			}else if(o==bt[1]) {//Login Menu
				card.show(p, "login");
			}else if(o==bt[2]) {//Join Menu
				card.show(p, "join");
			}else if(o==bt[3]) {//Users Menu
				//로그인 했을 때만 보여줘야 함
				card.show(p, "users");
			}else if(o==p1.btnLogin) {//로그인 버튼
				try {
					login();
				}catch(NotSupportedNameException ex) {
					JOptionPane.showMessageDialog(p1, ex.getMessage(),"경고", JOptionPane.WARNING_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(p1, ex.getMessage(),"경고", JOptionPane.PLAIN_MESSAGE);
					card.show(p, "home");
				}
			}else if(o==p3.btJoin) {
				joinMember();
			}else if(o==p3.btReset) {
				p3.clearTf();
			}else if(o==p4.btAll) {
				//전체 회원목록 가져오기
				listMembers();
			}else if(o==p4.btFind) {
				//검색
			}
		}
	}///////////////////////
	public void listMembers() {
		Collection<Member> col=usersMap.values();
		if(col==null|| col.size()==0) {
			p4.ta.setText(":::등록된 회원이 없습니다:::");
			return;
		}
		String info="Name\tTel\t\tPassword\n";
		info+="========================================\n";
		for(Member user:col) {
			info+=user.showInfo()+"\n";
		}
		p4.ta.setText(info);
	}//-----------------------------------
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(p3, msg,"alert",
				JOptionPane.WARNING_MESSAGE);
	}//----------------------------
	
	public void joinMember() {
		//1. 유효성 체크
		String name=p3.tfName.getText();
		char[] ch=p3.tfPwd.getPassword();
		String pwd=new String(ch);
		String tel=p3.tfTel.getText();
		//String의 trim(): 문자열 앞,뒤의 공백문자를 제거한다
		if(name==null||ch==null||tel==null|| name.trim().equals("")
				||ch.length<=0) {
			showMsg("이름, 비밀번호는 반드시 입력해야 해요");
			p3.tfName.requestFocus();
			return;
		}
		
		//2. 입력값들을 Member객체 담아주기
		Member user=new Member(name,pwd, tel);
		//3. usersMap에 "Name"---Member객체 매핑해저 저장
		usersMap.put(name, user);
		showMsg("회원가입 처리 되었습니다. 로그인 하세요");
		setTitle("현재 회원 수: "+usersMap.size()+"명");
		card.show(p, "login");
	}//-----------------------------------
	

	public static void main(String[] args) {
		new PongGui();
	}

}
