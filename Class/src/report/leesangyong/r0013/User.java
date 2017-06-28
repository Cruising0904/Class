package report.leesangyong.r0013;

public class User { //인터페이스는 기본생성자 만들수 없음. 그리고 파라메터는 무조건 인트타입
	private InterfaceExam ie; //인터페이스도 상속 가능함
	User(String operator){
		if(operator.equals("+")){
			ie = new Plus();
		}else if(operator.equals("-")){
			ie = new Minus();
		}else if(operator.equals("*")){
			ie = new Multiple();
		}else if(operator.equals("/")){
			ie = new Division();
		}else{
			System.out.println("연산자 잘못 입력");
		}
	}

	public InterfaceExam getInterfaceExam(){
		return ie;
	}
	
	public static void main(String[]args){
		User u = new User("+");
		InterfaceExam ie = u.getInterfaceExam();
		int result = ie.cal(3,4);
		System.out.println(result);
	}
}
