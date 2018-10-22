package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Lender extends Player {
	
	private List<Copy> copies;
	public List<Copy> getCopies(){
		return copies;
	}
	public void setCopies(List<Copy> copies) {
		this.copies=copies;
	}
	public Lender(String name, String firstname, String email, String password, String address, Date birthday,
			LocalDateTime registerDate, float amountUnit,List<Copy> copies) {
		super(name, firstname, email, password, address, birthday, registerDate, amountUnit);
		this.copies=copies;
	}
	public void addCopy(Copy copy) {
		copies.add(copy);
	}
	public Boolean removeCopy(Copy copy) {
		try {
			copies.remove(copy);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
