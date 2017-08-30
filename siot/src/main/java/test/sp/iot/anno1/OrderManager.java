package test.sp.iot.anno1;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("om")
public class OrderManager {
	private String name;
	
	@Autowired
	private Maker maker;
	@Autowired
	private Money money;
	
	public OrderManager() {}
	public void order() {
		money.setWon(10000);
		Car car = maker.sellCar(money);
	}
}
