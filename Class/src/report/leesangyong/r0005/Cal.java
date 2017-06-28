package report.leesangyong.r0005;

public class Cal {
// 클래스안에 스트링타입의 연산자를 저장하는 변수를 선언
// 생성자에서 연산자를 저장하는 로직을 만들고
// printCal()이라는 함수를 만들어 해당함수를 호출하였을때 알맞은 연산이 되는
// 프로그램을 만들어주세요
	int a;
	int b;
	String operator;
	Cal(int a){
		System.out.println(a+"인트형변수 파라메타를 가진 생성하셨네요");
		this.a = a;
	}
		  Cal(int a, int b,String operator ){
			this.a=a;
			this.b=b;
			this.operator = operator;
		}
		 void printCal(){
			 if(operator.equals("+")){
				 System.out.println("a+b="+(a+b));
			 }else if(operator.equals("-")){
				 System.out.println("a-b="+(a-b));
			 }else if(operator.equals("*")){
				 System.out.println("a*b="+(a*b));
			 }else if(operator.equals("/")){
				 System.out.println("a/b="+(a/b));
			 }else{
				 System.out.println("연산자가 틀렸어요");
			 }
	}
	
	
	public static void main(String[]args){
		Cal c = new Cal(3, 4,"+");
		c.printCal();
	}
}
