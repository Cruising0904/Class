package report.leesangyong.r0007;

import java.util.Scanner;

public class ArrExam2 {
	//Scanner 클래스의 nextLine()함수를 사용하여 초기값과 맥스값을 입력받아주세요
	// 위에서 받은 초기값부터 맥스값까지 반복하는 반복문을 작성해주세요.
	//스트링 배열변수를 선언해주세요.
	//해당 배열변수의 방의 갯수는 위에서 받아온 초기값과 맥스값으로 계산해야 에러가 나지 않습니다.
	//해당 반복문에서 Scanner클래스의 nextLine() 함수를 사용하여 위에서 선언한
	//스트링 배열변수에 0번째 인덱스부터 마지막 방의 인덱스까지 값을 받아주세요.
	//다음 반복문에서 스트링 배열변수가 가진 모든 방의 값을 출력
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);

		System.out.println("반복문의 초기값 입력");
		String input1 = scan.nextLine();
		int num1 = Integer.parseInt(input1);
		
		System.out.println("반복문의 초기값 입력");
		String input2 = scan.nextLine();
		int num2 = Integer.parseInt(input2);
		
		String[] str = new String[num2-num1+1];
		
		for(int i=num1;i<=num2;i++){
			System.out.println((i-num1)+"번째 배열변수값 입력");
			str[i-num1] = scan.nextLine();
			System.out.println(str[i-num1]);
		}
	}
}
