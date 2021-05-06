package test.study;

import test.human.Blood;
import test.human.Men;
import test.human.Person;
import test.human.Woman;

public class MyMain03 {
	public static void main(String[] args) {
		
		// 프로그래밍의 목적이 걷는것이다. 어떻게 하면 걸을 수 있을까?
		Blood b1 = new Blood("rh+","O");
		Person p1 = new Person(b1);
		p1.walk();
		// 혹은 
		Person p2 = new Person(new Blood("rh+","O"));
		p2.walk();
		
		// 프로그래밍의 목적이 영화를 보는 것이다! 어떻게 하면 될까?
		Men m = new Men(new Blood("rh+","O"));
		m.seeMovie();
		
		// 프로그래밍의 목적이 책을 읽는 것이다! 어떻게 하면 될까?
		Woman w = new Woman(new Blood("rh+","A"));
		w.reading();
		
		// 부모의 메소드 호출해보기
		m.walk();
		m.study();
		w.walk();
		w.study();
		
		// 다형성 확인하기
		Person w2=w;
		Object w3=w;
		Person m2=m;
		Object m3=m;
	}
}
