package report.leesangyong.r0007;

public class Exam5 {

	public static void main(String[]args){
		long[] a = new long[11];
		for(int i=0;i<=10;i++){
			a[i]=(long)Math.pow(10,i);//pow는 옆에는 몇승인지 나타내주는것.
			if(i!=0){					// math에 왠만한 수학공식 다 있음
				a[i]+=a[i-1];
				
			}
		}
		
		for(int i=0;i<=10;i++){
			System.out.println(a[i]);
		}
	}
}
