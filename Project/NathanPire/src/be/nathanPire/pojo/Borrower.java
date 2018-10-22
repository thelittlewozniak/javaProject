package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Borrower extends Player {

	private List<Reservation> reservations;
	public List<Reservation> getReservation(){
		return reservations;
	}
	public void setReservation(List<Reservation> reservations) {
		this.reservations=reservations;
	}
	public Borrower(String name, String firstname, String email, String password, String address, Date birthday,
			LocalDateTime registerDate, float amountUnit,List<Reservation> reservations) {
		super(name, firstname, email, password, address, birthday, registerDate, amountUnit);
		this.reservations=reservations;
	}
	public void addReservation(Reservation newReservation) {
		reservations.add(newReservation);
	}
	public Boolean removeReservation(Reservation delReservation) {
		try {
			reservations.remove(delReservation);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
