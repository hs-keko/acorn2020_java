package test.study;

import test.mypac.MyObject;
import test.mypac.Car;
import test.mypac.Radio;
import test.mypac.Speaker;


public class MyMain {
	public static void main(String[] args) {
		
		MyObject myObj=new MyObject();
		myObj.walk();
		int num=myObj.getNumber();
		String greet=myObj.getGreeting();
		
		/*
		 * 	동일한 패키지 혹은 java.lang 패키지에 속한 클래스가 아니면 반드시 import 해야 사용할 수 있다.
		 */
		
		
		
		// 메소드를 호출하면서 적절한 type 데이터를 전달해야 메소드를 호출할 수 있다.
		myObj.setNum(123);
		int num1=777;
		// int type 데이터가 들어 있는 변수명으로 데이터를 전달할수도 있다.
		myObj.setNum(num1);
		
		Car myCar=myObj.getCar();
		String myName="고현석";
		
		myObj.setName(myName);
		myObj.useCar(myCar);
		myObj.useSome(myName, myCar);
		
		Radio r1=new Radio();
		Speaker s1=new Speaker();
		myObj.doSome(r1, s1);
		
	
	}

}
