package report.leesangyong.r0006;

import java.util.Scanner;

public class CalExam {
	// 반복문을 사용하여 Scanner 클래스를 이용해
	// 총 10명의 학생의 점수를 받아주세요
	// 10명의 학생의 총점과 평균을 구해주세요 오름차순
	int[] a = new int[10];// 배열함수에 입력값 넣어줌
	int result = 0;

	void getScore() {
		for (int i = 0; i <= 9; i++) { // 순차적으로 배열 넣어줌
			Scanner scan = new Scanner(System.in);
			int input = Integer.parseInt(scan.nextLine());// 스캔으로 입력받고 정수로 변경
		result += a[i];
		for (int j = 0; j <= 9; j++) {
			if (a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i--;
			} else {
			}
		}
		a[i] = input; // 배열별로 점수 입력
	}

	}
	public static void main(String[] args) {
		CalExam c = new CalExam();
		c.getScore();
	}

}