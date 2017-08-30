package test.sp.iot.anno1;

import javax.inject.Named;

@Named
public class Money {

	private int won;
	public Money() {
	}
	public Money(int won) {
		this.won = won;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	
}
