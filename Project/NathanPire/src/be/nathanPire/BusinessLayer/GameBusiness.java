package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.nathanPire.dao.DaoGame;
import be.nathanPire.pojo.Game;

public class GameBusiness {
	private Connection conn;
	public GameBusiness() {
		conn=GetConnection.getInstance().getConnection();
	}
	public List<Game> getGames(){
		return new DaoGame(conn).getAll();
	}
	public Game getGameByName(String name) {
		var dao=new DaoGame(conn);
		var l=dao.getAll();
		Game g=null;
		for(int i=0;i<l.size();i++) {
			if(name.equals(l.get(i).getName())) {
				g = l.get(i);
			}
		}
		return g;
	}
	public void AddGame(Game g) {
		var dao=new DaoGame(conn);
		dao.create(g);
	}
}
