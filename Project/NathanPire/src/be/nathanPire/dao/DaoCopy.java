package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Copy;
import be.nathanPire.pojo.Game;

public class DaoCopy extends DAO<Copy> {

	private String sql;
	public DaoCopy(Connection conn) {
		super(conn);
		sql="";
	}

	@Override
	public boolean create(Copy obj) {
		sql="INSERT INTO Copy(idGame,idPlayer,AddDate) values("+obj.getGame().getID()+","+obj.getLender().getID()+","+obj.getAddDate()+")";
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
	public boolean delete(Copy obj) {
		sql="DELETE FROM Copy where idCopy="+obj.getID();
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
	public boolean update(Copy obj) {
		sql="UPDATE Copy SET idPlayer="+obj.getLender().getID()+",idGame="+obj.getGame().getID()+" where idPlayer="+obj.getID();
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
	public Copy find(int id) {
		Copy c=null;
		sql="SELECT * FROM Copy WHERE idCopy="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoGame g=new DaoGame(this.connect);
			DaoPlayer p=new DaoPlayer(this.connect);
			c=new Copy((Game)g.find(result.getInt("idGame")),result.getDate("AddDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			c.setLender(p.find(result.getInt("idPlayer")));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return c;
		}
		return c;
	}

	@Override
	public List<Copy> getAll() {
		List<Copy> c=new ArrayList<Copy>();
		sql="SELECT * FROM Game";
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoGame g=new DaoGame(this.connect);
			DaoPlayer p=new DaoPlayer(this.connect);
			while(result.next()) {
				var i=new Copy((Game)g.find(result.getInt("idGame")),result.getDate("AddDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				i.setLender(p.find(result.getInt("idPlayer")));
				c.add(i);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return c;
		}

		return c;
	}

}
