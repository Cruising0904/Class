package test.sp.iot.anno3;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String id;
	private String pwd;
	private String name;
	public User() {}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
