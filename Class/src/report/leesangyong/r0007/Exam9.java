package report.leesangyong.r0007;

import java.util.Scanner;

public class Exam9 {
	private int a;
	private int b;
	private int result = 0;
	Scanner scan;
	Exam9(){
		scan = new Scanner(System.in);
	}
	public void inputA(){
		System.out.println("시작값을 입력해주세요");
		this.a = Integer.parseInt(scan.nextLine());
	}
	public void inputB(){
		System.out.println("종료값을 입력해주세요");
		this.b = Integer.parseInt(scan.nextLine());
	}
		public void doLoop(){
		for (int i = a; i <= b; i++) {
			result += i;
		}
		System.out.println(result);
		}	
			
	}
