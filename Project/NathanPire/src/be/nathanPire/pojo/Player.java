package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Player extends User {
	private LocalDateTime registerDate;
	private float amountUnit;
	//GET && SET
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public float getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(float amountUnit) {
		this.amountUnit=amountUnit;
	}
	//Constructor
	public Player(String name, String firstname, String email, String password, String address, Date birthday,LocalDateTime registerDate,float amountUnit) {
		super(name, firstname, email, password, address, birthday);
		this.registerDate=registerDate;
		this.amountUnit=amountUnit;
	}
	public Player(String email,String password) {
		super(email,password);
		this.registerDate=LocalDateTime.now();
		this.amountUnit=10;
	}

}
