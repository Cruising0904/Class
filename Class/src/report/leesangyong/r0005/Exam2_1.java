package report.leesangyong.r0005;

public class Exam2_1 {
//0부터 4까지 반복하는 반복문을 작성하여
//Cal(int a)라고 선언된 생성자를 호출하여 1부터 5까지 출력을 해보시기 바랍니다.
		public static void main(String[]args){
			Cal[] c = new Cal[5];//Cal을 인트형이 아니기 때문에 출력시 null이 출력됨. 생성자가 아니고 방만 만들어줌
			for(int i=1;i<=4;i++){
				c[i]= new Cal(i+1);//앞에 만들어져있는 c를 사용하여 i값을 입력시킨다.
			}
			for(int i = 0; i<=4;i++){
				
			}
		}
}
