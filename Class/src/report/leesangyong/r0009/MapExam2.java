package report.leesangyong.r0009;

import java.util.HashMap;
import java.util.Iterator;

public class MapExam2 {
	HashMap<String, Integer> hm; //<>안에 선언을 안해주면 노란색으로 나옴.에러는 안남. 
	
	MapExam2(){
		hm = new HashMap<String, Integer>();
	}
	
	public static void main(String[]args){
		MapExam2 me = new MapExam2();
		me.hm.put("1",1); // put 할때 무조건 매게변수 2개 넣어줘야함
		me.hm.put("2",2); 
		me.hm.put("3",3); 
		me.hm.put("4",4); 
		me.hm.put("5",5); 
		
		Iterator it = me.hm.keySet().iterator();
		while(it.hasNext()){
			System.out.println((me.hm.containsKey("6")));// 키값이 있는지 물어보는함수. "6"의 인덱스값에 
			String key = (String)it.next();				// 입력된값이 없어서 false 로 값 출력
			System.out.println(key + ",");
			System.out.println(me.hm.get(key));
		}
	}
}
