package report.leesangyong.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypeExam5 {
	Scanner scan = new Scanner(System.in);
	public HashMap getHashMap(){
		HashMap hm = new HashMap();
		System.out.println("클래스 정보를 입력하세요!!");
		hm.put("클래스", scan.nextLine());
		System.out.println("이름 정보를 입력하세요!!");
		hm.put("이름", scan.nextLine());
		System.out.println("나이 정보를 입력하세요!!");
		hm.put("나이", scan.nextLine());
		System.out.println("성별 정보를 입력하세요!!");
		hm.put("성별", scan.nextLine());
		return hm;
	}

	public static void main(String[] args){
		ArrayList<HashMap> alList = new ArrayList<HashMap>();
		DataTypeExam5 dte5 = new DataTypeExam5();
		for(int i=0;i<2;i++){
			alList.add(dte5.getHashMap());
		}
		for(HashMap hm1 : alList){
			System.out.print(hm1.get("클래스") + ",");
			System.out.print(hm1.get("이름") + ",");
			System.out.print(hm1.get("나이") + ",");
			System.out.println(hm1.get("성별"));
		}
	}
}