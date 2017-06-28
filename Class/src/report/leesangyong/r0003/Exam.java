package report.leesangyong.r0003;

public class Exam {
	public void printPlusResult(int a, int b){
		System.out.println("더한결과값:"+(a+b));
	}
	public int getPlustResult(int a, int b){
		return a+b;
	}
	public static void main(String[]args){
		Exam e = new Exam();
		e.printPlusResult(1,3);
		int result = e.getPlustResult(1, 3);
		System.out.println("더한결과값:"+result);
	}
}
