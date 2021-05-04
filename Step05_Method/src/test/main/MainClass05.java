package test.main;

import test.mypac.ConvertUppercase;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  test.mypac 페키지에 다양한 모양의 메소드를 가지는 
		 *  클래스를 정의하고
		 *  그 클래스를 이용해서 객체도 생성하고 메소드도 호출해 보세요.
		 */
		ConvertUppercase c1 = new ConvertUppercase();
		c1.inputText="kimgura";
		c1.upper();
		c1.upperPrint();
		
	}
}
