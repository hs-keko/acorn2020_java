package test.mypac;

public abstract class Bug {
	public void prepare() {
		System.out.println("모기를 발견했다!");
	}
	public abstract void attack();
}
