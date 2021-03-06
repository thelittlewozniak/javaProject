package be.nathanPire.pojo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player extends User {
	private LocalDateTime registerDate;
	private float amountUnit;
	private List<Reservation> reservations;
	private List<Copy> copies;
	//GET && SET
	
	public List<Copy> getCopies(){
		return copies;
	}
	public void setCopies(List<Copy> copies) {
		this.copies=copies;
	}

	public List<Reservation> getReservation(){
		return reservations;
	}
	public void setReservation(List<Reservation> reservations) {
		this.reservations=reservations;
	}
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
	public Player(int ID,String name, String firstname, String email, String password, String address, Date birthday,LocalDateTime registerDate,float amountUnit,Boolean isAdmin) {
		super(ID,name, firstname, email, password, address, birthday,isAdmin);
		this.reservations=new ArrayList<Reservation>();
		this.copies=new ArrayList<Copy>();
		this.registerDate=registerDate;
		this.amountUnit=amountUnit;
	}
	public Player(String name,String firstname,String email,String password,String Address,Date date,Boolean isAdmin) {
		super(name, firstname, email, password, Address,date,isAdmin);
		this.registerDate=LocalDateTime.now();
	}
	public Player(String email,String password) {
		super(email,password);
		this.registerDate=LocalDateTime.now();
		this.amountUnit=10;
	}
	//Function to add a Reservation inside the list reservations
	//@input=Object reservation
	//@output=void
	public void addReservation(Reservation newReservation) {
		reservations.add(newReservation);
	}	
	//Function to remove a Reservation inside the list reservations
	//@input=Object Reservation
	//@output=Boolean
	public Boolean removeReservation(Reservation delReservation) {
		try {
			reservations.remove(delReservation);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	//Function to add a copy inside the list copies
	//@input=Object copy
	//@output=void
	public void addCopy(Copy copy) {
		copies.add(copy);
	}
	//Function to remove a copy inside the list copies
	//@input=Object copy
	//@output=Boolean
	public Boolean removeCopy(Copy copy) {
		try {
			copies.remove(copy);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
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
