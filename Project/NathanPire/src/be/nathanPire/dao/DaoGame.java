package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Game;

public class DaoGame extends DAO<Game> {
	private String sql;
	public DaoGame(Connection conn) {
		super(conn);
		sql="";
	}

	@Override
	public boolean create(Game obj) {
		sql="INSERT INTO Game(Name,Developers,Editor,Unit) values("+obj.getName()+","+obj.getDevelopers()+","+obj.getEditors()+","+obj.getUnit()+")";
		try {
			this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(Game obj) {
		sql="DELETE FROM Game WHERE idGame="+obj.getID();
		try {
			this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(Game obj) {
		Game g=obj;
		sql="UPDATE Game SET Name="+g.getName()+",Developers="+g.getEditors()+",Editor="+g.getEditors()+",Unit="+g.getUnit()+" where idGame="+g.getID();
		try {
			this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Game find(int id) {
		Game g=null;
		sql="SELECT * FROM Game WHERE idGame="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) {
				g=new Game(result.getInt("idGame"),result.getString("Name"),result.getString("Developers"),result.getString("Editor"),result.getFloat("Unit"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return g;
		}

		return g;
		}

	@Override
	public List<Game> getAll() {
		List<Game> g=new ArrayList<Game>();
		sql="SELECT * FROM Game";
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) {
				g.add(new Game(result.getInt("idGame"),result.getString("Name"),result.getString("Developers"),result.getString("Editor"),result.getFloat("Unit")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return g;
		}

		return g;
	}

}
