package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Reservation {
	private LocalDateTime reservationDate;
	private LocalDateTime beginDateWanted;
	private Game gameWanted;
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
	//Constructor
	public Reservation(Game gameWanted,LocalDateTime beginDateWanted) {
		this.gameWanted=gameWanted;
		this.beginDateWanted=beginDateWanted;
		this.reservationDate=LocalDateTime.now();
	}
}
