package report.leesangyong.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S {
		Scanner scan = new Scanner(System.in);
		ArrayList<HashMap> al = new ArrayList<HashMap>();
		HashMap hm = new HashMap();
		int a =0;
		void getData(){
			int i =0;
			while(i<a){
				i++;
		System.out.println("클래스을 입력해주세요");
		hm.put("클래스", scan.nextLine());
		System.out.println("이름을 입력해주세요");
		hm.put("이름", scan.nextLine());
		System.out.println("나이를 입력해주세요");
		hm.put("나이", scan.nextLine());
		System.out.println("성별을 입력해주세요");
		hm.put("성별", scan.nextLine());
		System.out.println(hm);
		}
		}
		public static void main(String[]args){
			S da = new S();
			System.out.println("입력할 데이터 수 입력");
			int endNum = Integer.parseInt(da.scan.nextLine());
			da.a = endNum;
			da.getData();
	}
}
