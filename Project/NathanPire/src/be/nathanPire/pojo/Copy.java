package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Copy {
	private Game game;
	private LocalDateTime addDate;
	private Lender lender;
	//GET && SET
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game=game;
	}
	public LocalDateTime getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDateTime addDate) {
		this.addDate=addDate;
	}
	public Lender getLender() {
		return lender;
	}
	public void setLender(Lender lender) {
		this.lender=lender;
	}
	//Constructor
	public Copy(Game game,Lender lender) {
		this.game=game;
		this.lender=lender;
		this.addDate=LocalDateTime.now();
	}
}
