package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Copy {
	private int ID;
	private Game game;
	private Player lender;
	private LocalDateTime addDate;
	//GET && SET
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game=game;
	}
	public Player getLender() {
		return lender;
	}
	public void setLender(Player lender) {
		this.lender=lender;
	}
	public LocalDateTime getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDateTime addDate) {
		this.addDate=addDate;
	}
	//Constructor
	public Copy(Game game,LocalDateTime date) {
		this.game=game;
		this.addDate=date;
	}
}
