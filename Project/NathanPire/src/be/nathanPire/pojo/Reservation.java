package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
	private int ID;
	private Date reservationDate;
	private Date beginDateWanted;
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
	public Date getReservationDate() {
		return reservationDate;
	}
	public Date getBeginDateWanted() {
		return beginDateWanted;
	}
	public Game getGameWanted() {
		return gameWanted;
	}
	public void setGameWanted(Game g) {
		this.gameWanted=g;
	}
	//Constructor
	public Reservation(Game gameWanted,Date beginDateWanted) {
		this.gameWanted=gameWanted;
		this.beginDateWanted=beginDateWanted;
		this.reservationDate=new Date();
	}
	public Reservation(Game gameWanted,Date beginDateWanted,Date reservationDate) {
		this.gameWanted=gameWanted;
		this.beginDateWanted=beginDateWanted;
		this.reservationDate=reservationDate;
	}
}
