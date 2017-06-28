package report.leesangyong.r0013;

public class Division implements InterfaceExam {
	@Override
	public String getString() {
		return "Test의 getString()함수 호출!!";
	}

	@Override
	public void setString(String str) {
		System.out.println("Test 의 setString()함수 호출!!" + str);
	}
	
	public int cal(int a, int b){
		return a/b;
	}

	@Override
	public void setInt(int str) {
		// TODO Auto-generated method stub
		
	}
}