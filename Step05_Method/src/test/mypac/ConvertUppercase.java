package test.mypac;

public class ConvertUppercase {
	// 입력한 문자를 저장할 field
	public String inputText;
	
	// 소문자를 대문자로 변환하여 리턴하는 method
	public String upper() {
		String result=inputText.toUpperCase();
		return result;
	}
	
	// 변환된 대문자를 콘솔에 출력하는 method
	public void upperPrint() {
		System.out.println("입력한 문자:"+inputText+"/ 대문자 변환:"+upper());
	}
}
