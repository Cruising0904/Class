package test.sp.iot.xml1;

public class Benz {

	public Benz() {
	}
	
	public Car sellCar(Money money) {
		Car car = new Car("5S");
		System.out.println(money.getWon()+"을 받고"+car.getName()+"를 팔았습니다.");
		return car;
	}
}
