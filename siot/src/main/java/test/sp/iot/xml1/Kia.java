package test.sp.iot.xml1;

public class Kia {

	public Kia() {
	}
	
	public Car sellCar(Money money) {
		Car car = new Car("K7");
		System.out.println(money.getWon()+"을 받고"+car.getName() +"차를 팔았습니다.");
		return car;
	}
}
