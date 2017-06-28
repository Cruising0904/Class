package report.leesangyong.r0006;

public class Son extends Father{// extends Father를 통해서 Son클래스에서 상속받아 사용가능. 
	int a;							// 다중상속 불가능
							// private 을 앞에 써주면 상속 안되게 함.(다른클래스에서 사용불가)
	
	public static void main(String[]args){
		Son s = new Son();
		s.a = 3;
		System.out.println(s.getAddress());
		System.out.println(s.getAge());
		System.out.println(s.getName());
		s.setName("이상용");
		System.out.println(s.getName());
	}
}
