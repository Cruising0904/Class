package test.sp.iot.anno4;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
@Service
public interface InputBallNum {
	public void setScanner(Scanner scan);
	public List<Integer> inputNumList();
}
