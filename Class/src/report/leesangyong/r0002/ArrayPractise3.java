package report.leesangyong.r0002;

public class ArrayPractise3 {

	public int[] getArrayVar(int intiNum, int maxNum){
		int[] a = new int[maxNum-intiNum];
		for(int i=intiNum-intiNum;i<maxNum-intiNum;i++){
			a[i] = i+1;
		}
		return a;
	}
		public void printArrayVar(int[] a){
		
		for(int i =a.length-1;i>=0;i--){
			System.out.println("a의"+i+"번째방의값="+a[i]);
			
		}
	}
	public static void main(String[] args){
		ArrayPractise3 ae3 = new ArrayPractise3();
		int[] a= ae3.getArrayVar(0,5);
		ae3.printArrayVar(a);
		}
	}
