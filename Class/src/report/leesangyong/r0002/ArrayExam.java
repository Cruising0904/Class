package report.leesangyong.r0002;

public class ArrayExam {
	public void printMultipleTable(int[] a, int[] b){
		// a.length a의 배열값 출력
	for(int i=0;i<a.length;i++){
		for(int j=0;j<b.length;j++){
		System.out.print(a[i]+"X"+b[j]+"="+(b[j]*a[i])+",");
	}
	System.out.println();
	}
 }
	public static void main(String[]args){
		int[] a = {1,2,3,4,5,6,7,8,9};
		int[] b = {1,2,3,4,5,6,7,8,9};
		ArrayExam ae = new ArrayExam();
		ae.printMultipleTable(a,b);
	}
}