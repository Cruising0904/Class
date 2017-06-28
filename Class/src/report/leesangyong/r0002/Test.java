package report.leesangyong.r0002;

public class Test {
	
	public void printMultipleTable(int initNum, int maxNum){
		
		for (int i = initNum; i <= maxNum; i++) {
			int a =1;
			for (a = initNum; a <= maxNum; a++) {
				System.out.printf(i+"X"+a+ "="+(i*a)+",");
			}
			System.out.println(i+"X"+a+ "="+(i*a)+",");
			}		
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.printMultipleTable(1, 5);

	}

}