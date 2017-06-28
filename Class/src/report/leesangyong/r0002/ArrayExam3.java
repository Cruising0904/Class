package report.leesangyong.r0002;

public class ArrayExam3 {

	//return 을 반드시 받아야함
	public int[] getArrayVar(int intiNum, int maxNum){
//		initNum으로 시작해서 maxNum종료되는 반복문을 사용하여
//		배열변수 a값을 집어넣고 배열변수a를 출력해주시면 됩니다.
//		출력은 main함수에서 출력해주세요
		int[] a = new int[maxNum-intiNum];
		for(int i=intiNum-intiNum;i<maxNum-intiNum;i++){
			a[i] = i+1;
		}
		return a;
	}//메인에서 a를 가져오려고 getArrayVar에 파라미터 넣어줌
		public void printArrayVar(int[] a){
		
		for(int i =0;i<a.length;i++){
			System.out.println("a의"+i+"번째방의값="+a[i]);
			
		}
	}
	public static void main(String[] args){
		ArrayExam3 ae3 = new ArrayExam3();
		int[] a= ae3.getArrayVar(0,5);
		ae3.printArrayVar(a);
		}
	}
