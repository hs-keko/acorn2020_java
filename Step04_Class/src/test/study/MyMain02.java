package test.study;

import java.io.PrintStream;

public class MyMain02 {
	public static void main(String[] args) {
		System.out.println("고현석");
		
		PrintStream a=System.out;
		a.println("해골");
		a.println("원숭이");
		
		long current=System.currentTimeMillis();
		a.println(current);
		
		String str=new String("안녕하세요");
		String str2="안녕하세요";
	}
}
