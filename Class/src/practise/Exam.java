package practise;

import java.util.Arrays;
import java.util.Scanner;

public class Exam {
public static void main(String[]args){
	Scanner scan = new Scanner(System.in);
	int sum = 0;
	int[] a = new int[5];
	for(int i=0;i<5;i++){
		System.out.println("점수 입력");
		a[i] = Integer.parseInt(scan.nextLine());
		sum += a[i];
	}
	System.out.println("총점="+sum);
	System.out.println("평균="+sum/5);
	for(int i=0;i<5;i++){
		Arrays.sort(a);
		System.out.println(a[i]);
	}
	
}
}
