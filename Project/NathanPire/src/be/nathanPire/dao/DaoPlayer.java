package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Player;
import be.nathanPire.pojo.Reservation;

public class DaoPlayer extends DAO<Player>{

	private String sql;
	public DaoPlayer(Connection conn) {
		super(conn);
		sql="";
	}

	@Override
	public boolean create(Player obj) {
		sql="INSERT INTO Player(Name,Firstname,Birthday,Email,Password,Address,Amount,RegisterDate,Admin) values("+obj.getName()+","+obj.getFirstname()+","+obj.getBirthday()+","+obj.getEmail()+","+obj.getPassword()+","+obj.getAddress()+","+obj.getAmountUnit()+","+obj.getRegisterDate()+",false)";
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
	public boolean delete(Player obj) {
		sql="DELETE FROM Player where idPlayer="+obj.getID();
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
	public boolean update(Player obj) {
		sql="UPDATE Player SET Name="+obj.getName()+",Firstname"+obj.getFirstname()+",Birthday"+obj.getBirthday()+",Email="+obj.getEmail()+",Password"+obj.getPassword()+",Address="+obj.getAddress()+",Amount="+obj.getAmountUnit()+",RegisterDate="+obj.getRegisterDate()+",Admin=false where idPlayer="+obj.getID();
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
	public Player find(int id) {
		sql="SELECT * FROM Player where idPlayer="+id;
		Player p=null;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			p=new Player(result.getInt(0),result.getString("Name"),result.getString("Firstname"),result.getString("Email"),result.getString("Password"),result.getString("Address"),result.getDate("Birthday"),result.getDate("RegisterDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),result.getFloat("Amount"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		sql="SELECT * FROM Reservation where idPlayer="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoReservation r=new DaoReservation(this.connect);
			while(result.next()) {
				p.addReservation((Reservation)r.find(result.getInt("idReservation")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		sql="SELECT * FROM Copy where idPlayer="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) {
				//NEED TO IMPLEMENT
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		sql="SELECT * FROM Loan where idPlayer="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) {
				//NEED TO IMPLEMENT
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Player> getAll() {
		List<Player> players=new ArrayList<Player>();
		sql="SELECT * FROM Player";
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			while(result.next()) {
				players.add(new Player(result.getInt(0),result.getString("Name"),result.getString("Firstname"),result.getString("Email"),result.getString("Password"),result.getString("Address"),result.getDate("Birthday"),result.getDate("RegisterDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),result.getFloat("Amount")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return players;
	}
	
}
