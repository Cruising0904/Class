package test.sp.iot.xml1;

public class OrderManager implements OrderInterface{

	private Kia kia;
	
	public OrderManager() {
		
	}
	
	public void setKia(Kia kia) {
		this.kia = kia;
	}
	
	public void order() {
		Money m = new Money(1000000);
		Car c = this.kia.sellCar(m);
	}
}
