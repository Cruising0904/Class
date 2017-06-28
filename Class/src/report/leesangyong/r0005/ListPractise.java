package report.leesangyong.r0005;

import java.util.ArrayList;

public class ListPractise {
	public static void main(String[] args) {
		Cal2 ca = new Cal2();
		ArrayList list = new ArrayList();
		list.add(ca.num1);
		int num = (int) list.get(1);//다이아몬드로 안해줄땐 이렇게 형변환을 해줘야함
		System.out.println(num);
	}
}
