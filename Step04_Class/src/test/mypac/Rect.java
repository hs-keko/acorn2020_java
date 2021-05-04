package test.mypac;

// 사각형의 정보를 담을수 있는 Rect 클래스 
public class Rect {
	//non static 필드 
	public int width; //폭
	public int height; //높이
	
	//사각형의 면적을 리턴해주는 non static 메소드 
	public int getArea() {	// 이 method 를 실행하면 int 값을 리턴해준다.
		int area=this.width * this.height;
		return area;	// return 다음에 반드시 int 값이 와야 문법에 맞는다.   
						// return true(x), return "김구라"(x), return 10.1(x)
	}
}
