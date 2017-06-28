package report.leesangyong.r0013;

import java.util.List;//유틸 인터페이스

import com.google.common.collect.Lists;

public class ListExam2 {

	public void arrayToListWithGuava(){
		Integer[] sourceArray = {0,1,2,3,4,5};
		List<Integer> targetList = Lists.newArrayList(sourceArray); //c+s+o구아바에서 제굉된
	}
	public static void main(String[]args){
		ListExam2 ie = new ListExam2();
	}
}
