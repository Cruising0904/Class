package report.leesangyong.r0005;

public class Cal_2 {

	int a;
	int b;
	String operator;
		  Cal_2(){
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
