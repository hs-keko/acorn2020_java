package test.frame1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 레이 아웃 매니저를 FlowLayout 으로 지정한다
		// setLayout(new FlowLayout(0));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn1=new JButton("버튼1");
		//버튼의 위치
		btn1.setLocation(10, 10);
		//버튼의 크기
		btn1.setSize(100, 30);
		add(btn1); //프레임에 btn1 추가 하기 
		
		JButton btn2=new JButton("버튼2");
		//버튼의 위치와 크기를 한번에 지정하기 
		btn2.setBounds(120, 10, 100, 30);
		add(btn2); //프레임에 btn2 추가 하기
		
		JButton btn3=new JButton("버튼3");
		//버튼의 위치와 크기를 한번에 지정하기 
		btn3.setBounds(230, 10, 100, 30);
		add(btn3); //프레임에 btn3 추가 하기
		
		JButton btn4=new JButton("버튼4");
		//버튼의 위치와 크기를 한번에 지정하기 
		btn4.setBounds(340, 10, 100, 30);
		add(btn4); //프레임에 btn3 추가 하기
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}








