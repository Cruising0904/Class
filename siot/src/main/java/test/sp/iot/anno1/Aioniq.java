package test.sp.iot.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aioniq implements Maker{
	
	private Car car;
	public Car sellCar(Money money) {
		car.setName("Aioniq");
		System.out.println("기아회사에서 "+car.getName() +"을 "+ money.getWon()+"원 에 차 매매");
		return car;
	}

}
