package report.leesangyong.r0004;

import java.util.Scanner;

public class Calpoint {
//Scanner클래스를 사용하여 6명의 학생의 점수를 직접 입력받아주세요.
//6명의 학생의 총점을 출력해주세요.
	public static void main(String[]args){
	Scanner scan = new Scanner(System.in);
	int result =0;// 선언하면서 0값을 넣어주어 초기화 받은값을 넣어줄 곳이 필요해서
	int[] num = new int[6];
	for(int i=0;i<=5;i++){
		System.out.println((i+1)+"번째 학생의 점수를 입력해주세요=>:");//출력문 출력해주면서
		String numStr = scan.nextLine(); // 입력값 받음
		num[i]=Integer.parseInt(numStr); // 배열변수에 입력값받은걸 값입력
		result += num[i]; // +=가 위에서 받은값 하나씩 더하는 역할
		
	} 
	System.out.println("학생들의 총점수="+(result));
	for(int i=0;i<num.length;i++){ // num.length  선언한 num[]의 배열변수의 길이
		System.out.println((i+1)+"번째 학생들의 점수"+num[i]);
	} // 주의 int i 는 포문에서 선언했으므로 포문 밖에선 사용 안됨.
	  // 반대로 num[]은 메인 함수 영역에 있어 사용 가능.
}
}