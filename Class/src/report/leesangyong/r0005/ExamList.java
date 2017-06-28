package report.leesangyong.r0005;

import java.util.ArrayList;

public class ExamList {
	public static void main(String[] args) {
		ArrayList<Cal> list = new ArrayList<Cal>();// list에 칼만 넣겠다는 의미 <>
		for (int i = 0; i < 3; i++) {
			Cal c = new Cal(1); // 안그러면 느낌표 나타남
			list.add(c);
		}

		Cal c2 = list.get(0);
		System.out.println(c2.a);
	}
}
