package report.leesangyong.r0006;

public class Exam3 {
int getIndexFromArray(int[] arr, int num){ // 배변1값 포문으로 설정된거 num(30)이랑 대조하여 값 찾기
	for(int i=0;i<arr.length;i++){			// 위에 선언된 arr배열 포문에서 찾기 시작 밑에 if문으로
		if(arr[i]==num){				// 우리가 밑에 입력했던 값30이 맞는지 배열변수2를 돌리며 확인
			return i;			//num(30)이 맞으면 그 i 값을 밑에 idx에 보내줌.ex)첫번재, 두번째,,,
		}
	}
	return -1;
}
	public static void main(String[] args) {
		int[] a = new int[5];  //배열변수1 선언
		for(int i=0;i<5;i++){  //배변1의 값 정리
			a[i] = (i+1)*10;	//배변1의 값 설정 
		}
		Exam3 e3 = new Exam3();
		int idx = e3.getIndexFromArray(a, 30); // 배변1값, 30은 찾기위한값
		System.out.println("30이란 값을 가지고 있는 방의 index"+idx);
		} // 
	}

