package report.leesangyong.r0006;

public class NewExam {// 클래스 자동생성 설명 생성자 만들지 않아도 자동으로 만들어지며,
						// 밑에 두 예제 값은 true 밑의 건 false 가 나온다
						// 이유는 ==은 주소값을 비교하는데 밑에건 새로 선언을 하기 때문에
						// 새로 선언할때 같은걸 선언할수 없기 때문.

	public static void main(String[]args){
		String str1 = "a";
		String str2 = "a";
		System.out.println(str1==str2);
		str1 = new String("b");
		str2 = new String("b");
		System.out.println(str1==str2);
	}
}
