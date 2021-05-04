package test.mypac;

public class Member {
	//non static 필드 정의하기
	public int num;
	public String name;
	public String addr;
	
	//non static 메소드 정의하기
	public void showInfo() {	// void : 어떤 값도 리턴하지 않을거니 받아갈 생각도 하지마!
		System.out.println(this.num+" | "+this.name+" | "+this.addr);	
	
	}
}






