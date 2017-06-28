package report.leesangyong.r0005;


public class Exam {
	public static void main(String[]args){
//	Robot 클래스가 가지고 있는 3가지 함수를 호출해서 결과값을 출력해주세요	
//	단 로봇의 이름은 지로봇 나이는 10살 입니다.
//	Cal클래스를 사용하여 더하기 빼기 곱하기 나누기 연산값을 출력해주세요	
//	단 첫번째 변수는 10 두번째 변수는 2입니다.	
		Robot r = new Robot("지로봇",10);
		r.doKick();
		r.doRun();
		r.doChange();
				
		Cal c = new Cal(3, 4,"+");
		c.printCal();                                                                                                                                                                                                                             
		c = new Cal(3, 4,"-");
		c.printCal();
		c = new Cal(3, 4,"*");
		c.printCal();
		c = new Cal(3, 4,"/");
		c.printCal();
	}
}
