package report.leesangyong.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam6 {

	public static void main(String[]args){
		DataTypeExam5 d5 = new DataTypeExam5();
		ArrayList<HashMap> alList = new ArrayList<HashMap>();
		DataTypeExam5 dt5 = new DataTypeExam5();
		for(int i=0;i<2;i++){
			alList.add(d5.getHashMap());
		}
		for(HashMap hm1 : alList){
			System.out.print(hm1.get("클래스") + ",");
			System.out.print(hm1.get("이름") + ",");
			System.out.print(hm1.get("나이") + ",");
			System.out.println(hm1.get("성별"));
		}
	}

	private static Object alList() {
		// TODO Auto-generated method stub
		return null;
	}
}
