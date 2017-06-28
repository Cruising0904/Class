package report.leesangyong.r0007;

public class Exam11 {
 protected int a;
 protected int b;
 //a와 b값을 초기화 하는 Exam11생성자를 만들어주세요
 //a와 b값을 더하기, 빼기, 나누기, 곱하기 하는 함수를 각각 4개 작성해주시고
 //해당연산결과는 printResult()라는 함수를 호출햇을때 나오게 프로그램을 작성해주시면 됩니다.
 //호출은 Exam12라는 클래스를 만들어서 그안에서 해주시기 바랍니다.
 public Exam11(){}//선언이 안되어있으면 상속 에러남, 밑에 파라메타가 있는 생성자면
 public Exam11(int a, int b){
 this.a=a;
 this.b=b;
 
 }
protected void operPlus(){
	int sum = a+b;
	System.out.println("더하기 결과="+sum);
}
protected void operMinus(){
	int min = a-b;
	System.out.println("빼기 결과="+min);
}
protected void operMultiple(){
	int mul = a*b;
	System.out.println("곱하기 결과="+mul);
}
protected void operDivision(){
	int div = a/b;
	System.out.println("나누기기 결과="+div);
}

protected void printResult(){
	 operPlus();
	 operMinus();
	 operMultiple();
	 operDivision();
	
 }
}
