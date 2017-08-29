package test.sp.iot.xml1;

public class OrderManager2 implements OrderInterface{

	private Kia kia;
	
	public OrderManager2() {
		this.kia = new Kia();
	}
	
	public void order() {
		Money m = new Money(1000000);
		Car c = this.kia.sellCar(m);
	}
	public void setKia(Kia kia) {
		this.kia = kia;
	}
}
