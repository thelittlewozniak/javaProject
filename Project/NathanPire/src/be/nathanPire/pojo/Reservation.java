package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Reservation {
	private int ID;
	private LocalDateTime reservationDate;
	private LocalDateTime beginDateWanted;
	private Player player;
	private Game gameWanted;
	//GET && SET
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player=player;
	}
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
