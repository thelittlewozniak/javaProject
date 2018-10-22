package be.nathanPire.pojo;

import java.util.Date;

public class Admin extends User {

	public Admin(String name, String firstname, String email, String password, String address, Date birthday) {
		super(name, firstname, email, password, address, birthday);
	}
	public Boolean addGame() {
		//NEED TO BE DONE
		return true;
	}
	public Boolean ModifyUnit() {
		//NEED TO BE DONE
		return true;
	}

}
