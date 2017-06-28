package report.leesangyong.r0004;

import java.util.Scanner;

public class Calpoint2 {
//Scanner클래스를 사용하여 6명의 학생의 점수를 직접 입력받아주세요.
//6명의 학생의 총점을 출력해주세요.
	public static void main(String[]args){
	Scanner scan = new Scanner(System.in);
	
	String input1= scan.nextLine();
	int stu1 = Integer.parseInt(input1);
	
	String input2= scan.nextLine();
	int stu2 = Integer.parseInt(input2);
	
	String input3= scan.nextLine();
	int stu3 = Integer.parseInt(input3);
	
	String input4= scan.nextLine();
	int stu4 = Integer.parseInt(input4);
	
	String input5= scan.nextLine();
	int stu5 = Integer.parseInt(input5);
	
	String input6= scan.nextLine();
	int stu6 = Integer.parseInt(input6);
	
	int sum = stu1+stu2+stu3+stu4+stu5+stu6;
	
	
	System.out.println("학생들의 총점수="+sum);
}
}