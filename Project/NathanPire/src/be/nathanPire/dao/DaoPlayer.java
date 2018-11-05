package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Player;
import be.nathanPire.pojo.Reservation;

public class DaoPlayer extends DAO{

	private String sql;
	public DaoPlayer(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Object obj) {
		Player p=null;
		try {
			p=(Player) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="INSERT INTO Player(Name,Firstname,Birthday,Email,Password,Address,Amount,RegisterDate,Admin) values("+p.getName()+","+p.getFirstname()+","+p.getBirthday()+","+p.getEmail()+","+p.getPassword()+","+p.getAddress()+","+p.getAmountUnit()+","+p.getRegisterDate()+",false)";
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
		Player p=null;
		try {
			p=(Player) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="DELETE FROM Player where idPlayer="+p.getID();
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
		Player p=null;
		try {
			p=(Player) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="UPDATE Player SET Name="+p.getName()+",Firstname"+p.getFirstname()+",Birthday"+p.getBirthday()+",Email="+p.getEmail()+",Password"+p.getPassword()+",Address="+p.getAddress()+",Amount="+p.getAmountUnit()+",RegisterDate="+p.getRegisterDate()+",Admin=false where idPlayer="+p.getID();
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
