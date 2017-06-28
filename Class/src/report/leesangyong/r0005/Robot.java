package report.leesangyong.r0005;

public class Robot {
	String name;
	int age;
	public Robot(String name,int age){
		this.name = name;
		this.age = age;
	}
	void doKick(){
		System.out.println(age+"살먹은 로봇"+name+"이/가 발차기를 하였습니다");
	}
	void doRun(){
		System.out.println(age+"살먹은 로봇"+name+"이/가 달리기를 하였습니다");
		
	}
	void doChange(){
		System.out.println(age+"살먹은 로봇"+name+"이/가 변신을 하였습니다");
		
	}
	public static void main(String[]args){
		Robot rb= new Robot("태권브이",4);
		rb.doKick();
		rb.doRun();
		rb.doChange();
		
	}
}
