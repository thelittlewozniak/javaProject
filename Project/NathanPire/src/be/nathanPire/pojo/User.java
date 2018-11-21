package be.nathanPire.pojo;

import java.util.Date;

public abstract class User {
	private int ID;
	private String name;
	private String firstname;
	private String email;
	private String password;
	private String address;
	private Date birthday;
	//GET && SET
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname=firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday=birthday;
	}
	//Constructor
	public User(int ID,String name,String firstname,String email,String password,String address,Date birthday) {
		this.ID=ID;
		this.name=name;
		this.firstname=firstname;
		this.email=email;
		this.password=password;
		this.address=address;
		this.birthday=birthday;
	}
	public User(String name,String firstname,String email,String password,String address,Date birthday) {
		this.name=name;
		this.firstname=firstname;
		this.email=email;
		this.password=password;
		this.address=address;
		this.birthday=birthday;
	}
	public User(String email,String password) {
		this.name="";
		this.firstname="";
		this.email=email;
		this.password=password;
		this.address="";
		this.birthday=new Date();
	}
}
