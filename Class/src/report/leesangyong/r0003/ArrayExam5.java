package report.leesangyong.r0003;

public class ArrayExam5 {
//	자리수가 6개인 인트형 배열변수 a를 선언
//	총 6번 반복하는 반복문에서 로또 로직 만들기
//	아래에서 나오는 랜덤값을 배연변수 a에 0번째 방부터 차례로 입력
	public static void main(String[]args){
	int[] a = new int[6] ;
	for(int i=0;i<6;i++){
		int random = (int)(Math.random()*45)+1;
		a[i]=random;
		for(int j=i+1;j>=0;j--){
			if(j<6&&a[j]==a[i]&&i!=j){
			j=0;
			i--;
		}
		}
	}
	for(int i=0;i<6;i++){
		System.out.println((i+1)+"번째 로또번호는:"+a[i]);
}
}
}