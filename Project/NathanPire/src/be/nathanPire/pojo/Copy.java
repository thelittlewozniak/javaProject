package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Copy {
	private Game game;
	private LocalDateTime addDate;
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
	//Constructor
	public Copy(Game game) {
		this.game=game;
		this.addDate=LocalDateTime.now();
	}
}
