package be.nathanPire.pojo;

import java.util.Date;

public class Admin extends User {
	//Constructor
	public Admin(int ID,String name, String firstname, String email, String password, String address, Date birthday) {
		super(ID,name, firstname, email, password, address, birthday);
	}
	//Function to add a game
	//@input=Object game
	//@output=void
	public void addGame() {
		//NEED TO BE DONE
	}
	//Function to modify the unit of each game
	//@input=float unit to add or remove
	//@output=Boolean
	public Boolean ModifyUnit() {
		//NEED TO BE DONE
		return true;
	}

}
