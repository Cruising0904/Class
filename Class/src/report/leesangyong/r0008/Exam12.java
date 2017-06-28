package report.leesangyong.r0008;

import report.leesangyong.r0007.Exam11;

public class Exam12 extends Exam11 {//아들에서 상속선언해야함

	Exam12(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args) {
		Exam12 e12 = new Exam12(1, 2);
		e12.printResult();
	}
}
