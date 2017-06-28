package report.leesangyong.r0009;

public class Son extends Father{
	public String toString(){	//toString 오버라이딩 하면서 자주 사용함.
		return "아부지 아들입니다.";
	}
	
	public static void main(String[]args){
		Father f = new Father();
		System.out.println(f);
		Son s = new Son();
		System.out.println(s);
	}
}
