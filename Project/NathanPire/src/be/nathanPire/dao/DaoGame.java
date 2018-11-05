package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Game;

public class DaoGame extends DAO {
	private String sql;
	public DaoGame(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Object obj) {
		Game g=null;
		try {
			g=(Game) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="INSERT INTO Game(Name,Developers,Editor,Unit) values("+g.getName()+","+g.getDevelopers()+","+g.getEditors()+","+g.getUnit()+")";
		try {
			ResultSet result = this.connect.createStatement(
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
	public boolean delete(Object obj) {
		Game g=null;
		try {
			g=(Game) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="DELETE FROM Game WHERE idGame="+g.getID();
		try {
			ResultSet result = this.connect.createStatement(
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
	public boolean update(Object obj) {
		Game g=null;
		try {
			g=(Game) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="UPDATE Game SET Name="+g.getName()+",Developers="+g.getEditors()+",Editor="+g.getEditors()+",Unit="+g.getUnit()+" where idGame="+g.getID();
		try {
			ResultSet result = this.connect.createStatement(
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
	public Object find(int id) {
		Game g=null;
		sql="SELECT * FROM Game WHERE idGame="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			g=new Game(result.getInt("idGame"),result.getString("Name"),result.getString("Developers"),result.getString("Editor"),result.getFloat("Unit"));
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
