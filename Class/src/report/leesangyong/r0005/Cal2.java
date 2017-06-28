package report.leesangyong.r0005;
public class Cal2 {
	Cal2(){}
//int형변수 2개를 멤버변수로(클래스안에서 생성해야된다는 겁니다.)
//스트링형 변수 1개를 생성해주세요.
//num1, num2, operator
	
// printPlus(), printMinus(), printMultiple(), printDivision()
// Cal2(int num1, int num2, String operator)생성자를 선언하여
//각각의 멤버변수에 대입해주세요
//그리고 위의 함수를 호출했을때 원하는 결과값을 출력해주세요

 int num1, num2;
 
 String operator;
 
 void printPlus(){
			System.out.println(num1+num2);
			 }
void printMinus(){
		System.out.println(num1-num2);
 }
 void printMultiple(){
		System.out.println(num1*num2);
 }
 void printDivision(){
	 	System.out.println(num1/num2);
	 
 }
 Cal2(int num1, int num2, String operator){
	 this.num1 =num1 ;
	 this.num2 =num2 ;
	 this.operator =operator  ;
 }
 public static void main(String[]args){
	 Cal2 c2 = new Cal2(2,5,"");
	 c2.printPlus();
	 c2.printMinus();
	 c2.printMultiple();
	 c2.printDivision();
 }
}
