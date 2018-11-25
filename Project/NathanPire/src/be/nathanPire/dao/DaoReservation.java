package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Reservation;

public class DaoReservation extends DAO<Reservation>{

	private String sql;
	public DaoReservation(Connection conn) {
		super(conn);
		sql="";
	}

	@Override
	public boolean create(Reservation obj) {
		String dateReservation=new SimpleDateFormat("dd/MM/yyyy").format(obj.getReservationDate());
		String beginDateWanted=new SimpleDateFormat("dd/MM/yyyy").format(obj.getBeginDateWanted());
		sql="INSERT INTO Reservation(DateReservation,BeginDateWanted,idPlayer,idGame) values('"+dateReservation+"','"+beginDateWanted+"','"+obj.getPlayer().getID()+"','"+obj.getGameWanted().getID()+"')";
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
	public boolean delete(Reservation obj) {
		sql="DELETE FROM Reservation WHERE idReservation="+obj.getID();
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
	public boolean update(Reservation obj) {
		sql="UPDATE Reservation SET BeginDateWanted="+obj.getBeginDateWanted();
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
	public Reservation find(int id) {
		Reservation r=null;
		sql="SELECT * FROM Reservation WHERE idReservation="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
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
				DaoPlayer p =new DaoPlayer(this.connect);
				r=new Reservation((Game)g.find(result.getInt("idGame")),BeginDateWanted,reservationDate);
				r.setPlayer(p.find(result.getInt("idPlayer")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return r;
		}
		
		return r;
	}

	@Override
	public List<Reservation> getAll() {
		List<Reservation> r=new ArrayList<Reservation>();
		sql="SELECT * FROM Reservation";
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoGame g=new DaoGame(this.connect);
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

				r.add(new Reservation((Game)g.find(result.getInt("idGame")),BeginDateWanted,reservationDate));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return r;
		}

		return r;
	}

}
