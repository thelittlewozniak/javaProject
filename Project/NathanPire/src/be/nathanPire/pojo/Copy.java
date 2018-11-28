package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Copy {
	private int ID;
	private Game game;
	private Player lender;
	private Date addDate;
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
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate=addDate;
	}
	//Constructor
	public Copy(Game game,Date date) {
		this.game=game;
		this.addDate=date;
	}
	public Copy(Game game,Player lender) {
		this.game=game;
		this.lender=lender;
		this.addDate=new Date();
	}
	public Copy(int ID,Game game,Date date) {
		this.ID=ID;
		this.game=game;
		this.addDate=date;

	}
}
