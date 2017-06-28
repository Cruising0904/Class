package report.leesangyong.r0004;

import java.util.Scanner;

public class Calpoint2_1 {
//Scanner클래스를 사용하여 6명의 학생의 점수를 직접 입력받아주세요.
//6명의 학생의 점수를 받아 평균을 구하고 점수를 오름차순해주세요.
	int total = 0;
	int[] i = new int[6];
	public void getScore(){
	for(int j=0;j<=5;j++){
		System.out.println((j+1)+"학생의 점수");
		Scanner scan = new Scanner(System.in);//학생점수 입력
		String str = scan.nextLine(); //입력받는게 문자타입이기때문에
		i[j] = Integer.parseInt(str);//str선언했던걸 정수로 바꿔주면서 위에서 입력받은점수를 각배열마다 입력해줌
		total += i[j];//점수 받은거 i[j]로 보내주고 점수를 합산해서 토탈에 저장
		
	}
	System.out.println("학생들의 총점="+total);//총점 출력
	System.out.println("학생들의 평균="+total/i.length);//평균 출력
}
	
	public static void main(String[]args){
		Calpoint2_1 cal = new Calpoint2_1();	//클래스 선언
		cal.getScore();							//getScore 실행
		for(int a=0;a<=5;a++){
			System.out.println((a+1)+"번째학생의점수는"+cal.i[a]);
		}
}
	}