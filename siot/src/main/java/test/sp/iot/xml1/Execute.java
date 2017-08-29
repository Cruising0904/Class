package test.sp.iot.xml1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Execute {

	public static void main(String[]args) {
		FileSystemResource fsr = new FileSystemResource("src/main/resources/xml1/ioc.xml");
		BeanFactory bf = new XmlBeanFactory(fsr);
		Kia kia = (Kia)bf.getBean("kia1");
		OrderInterface om =(OrderInterface)bf.getBean("om");
		om.setKia(new Kia());
		om.order();
	}
}
