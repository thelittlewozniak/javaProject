package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.nathanPire.pojo.Game;
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
		String birthday=new SimpleDateFormat("dd/MM/yyyy").format(obj.getBirthday());
		String registerDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		sql="INSERT INTO Player(Name,Firstname,Birthday,Email,Password,Address,Amount,RegisterDate,Admin) values('"+obj.getName()+"','"+obj.getFirstname()+"','"+birthday+"','"+obj.getEmail()+"','"+obj.getPassword()+"','"+obj.getAddress()+"',"+10.0+",'"+registerDate+"',0)";
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
		String birthday=new SimpleDateFormat("dd/MM/yyyy").format(obj.getBirthday());
		String registerDate=new SimpleDateFormat("dd/MM/yyyy").format(obj.getRegisterDate());
		sql="UPDATE Player SET Name="+obj.getName()+",Firstname="+obj.getFirstname()+",Birthday="+birthday+",Email="+obj.getEmail()+",Password="+obj.getPassword()+",Address="+obj.getAddress()+",Amount="+obj.getAmountUnit()+",RegisterDate="+registerDate+",Admin=false where idPlayer="+obj.getID();
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
			while(result.next()) {
				Date registerDate=null;
				try {
					String test=result.getString("RegisterDate");
					registerDate=new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("RegisterDate"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date birthday=null;
				try {
					birthday = new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("Birthday"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				p=new Player(result.getInt("idPlayer"),result.getString("Name"),result.getString("Firstname"),result.getString("Email"),result.getString("Password"),result.getString("Address"),birthday,registerDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),result.getFloat("Amount"));
			}
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
				Date reservationDate=null;
				try {
					reservationDate=new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("DateReservation"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date BeginDateWanted=null;
				try {
					BeginDateWanted = new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("BeginDateWanted"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				DaoGame g=new DaoGame(this.connect);
				p.addReservation(new Reservation((Game)g.find(result.getInt("idGame")),BeginDateWanted,reservationDate));
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
		sql="SELECT * FROM Loan where Lender="+id;
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
				Date registerDate=null;
				try {
					registerDate=new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("RegisterDate"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date birthday=null;
				try {
					birthday = new SimpleDateFormat("dd/MM/yyyy").parse(result.getString("Birthday"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				players.add(find(result.getInt("idPlayer")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return players;
	}
	
}
