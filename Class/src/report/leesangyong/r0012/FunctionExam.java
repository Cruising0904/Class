package report.leesangyong.r0012;

import java.util.Scanner;

public class FunctionExam {
	int[] arrNum = new int[5];
	Scanner scan = new Scanner(System.in);
	int i = 0;
	int getNumberFromString(){
		try{
			i++;
			System.out.println(i+"번째 숫자를 넣어주세요");
			return Integer.parseInt(scan.nextLine());
		}catch(Exception e){
			i--;
			System.out.println("누가 문자 넣으래!");
		return getNumberFromString();
	}
	}
//	public static void main(String[]args){
//		FunctionExam ee2 = new FunctionExam();
//		for(int i = 0; i<ee2.arrNum.length;i++){
//			ee2.arrNum[i] = ee2.getNumberFromString();
//			}
//		for(int i = 0; i<ee2.arrNum.length;i++){
//			System.out.println(ee2.arrNum[i]);
//		}
//	}
}
