package test.sp.iot.anno2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class Designer implements Worker{

	@Override
	public void goToWork() {
		System.out.println("디자이너가 출근.");
		
	}

	@Override
	public void work() {
		System.out.println("디자이너가 일을 합니다.");
		
	}

	@Override
	public void getOffWork() {
		System.out.println("디자이너가 퇴근~ 신나게 노는거야! 아싸!!");
		
	}

}
