package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Reservation {
	private LocalDateTime reservationDate;
	private LocalDateTime beginDateWanted;
	private Game gameWanted;
	private Borrower borrower;
	//GET && SET
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}
	public LocalDateTime getBeginDateWanted() {
		return beginDateWanted;
	}
	public Game getGameWanted() {
		return gameWanted;
	}
	public Borrower borrower() {
		return borrower;
	}
	//Constructor
	public Reservation(Game gameWanted,Borrower borrower,LocalDateTime beginDateWanted) {
		this.gameWanted=gameWanted;
		this.borrower=borrower;
		this.beginDateWanted=beginDateWanted;
		this.reservationDate=LocalDateTime.now();
	}
}
