package test.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		File memoFile=new File("c:/acorn202104/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재 하지 않습니다.");
				return; //메소드 끝내기 
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr=new FileReader(memoFile);
			/*
			 * 	memo.txt 파일에 몇개의 문자가 있는지 잘 모름
			 * 	아래 3줄의 코드를 memo.txt 파일에 있는 모든 문자를 읽어올 때 까지 반복수행하고 싶음
			 * 
			 */
			
			// 이클립스(JVM) 야 아래의 세 줄 코드를 code 값이 -1 이 나올때까지 반복수행 해줘
			
			/* int code=fr.read();
			 * char ch=(char)code;
			 * System.out.print(ch);
			 */
			
			while(true) {
				// read() 메소드를 이용해서 읽은 문자의 코드값을 얻어낸다. 
				int code=fr.read();
				if(code==-1) {// 만약 다 일ㄲ었다면 
					break;//반복문 탈출 
				}
				//코드값에 해당되는 문자 얻어내기
				char ch=(char)code;
				// 문자 출력하기
				System.out.print(ch);
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}




