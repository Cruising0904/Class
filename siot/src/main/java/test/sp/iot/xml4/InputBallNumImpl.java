package test.sp.iot.xml4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class InputBallNumImpl implements InputBallNum{

	private Scanner scan;
	
	public void setScanner(Scanner scan){
		this.scan = scan;
	}
	
	public List<Integer> inputNumList(){
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("3개의 숫자를 ',' 로 구분하여 입력해주세요");
		String numStr = scan.nextLine();
		String[] nums = numStr.split(",");
		for(String s : nums){
			list.add(Integer.parseInt(s));
		}
		return list;
	}
}
