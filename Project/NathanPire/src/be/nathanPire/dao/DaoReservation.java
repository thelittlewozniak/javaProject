package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;
import be.nathanPire.pojo.Reservation;

public class DaoReservation extends DAO{

	private String sql;
	public DaoReservation(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Object obj) {
		Reservation r=null;
		try {
			r=(Reservation) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="INSERT INTO Reservation(DateReservation,BeginDateWanted,idPlayer,idGame) values("+r.getReservationDate()+","+r.getBeginDateWanted()+","+r.getPlayer().getID()+","+r.getGameWanted().getID()+")";
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
		Reservation r=null;
		try {
			r=(Reservation) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="DELETE FROM Reservation WHERE idReservation="+r.getID();
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
		Reservation r=null;
		try {
			r=(Reservation) obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		sql="UPDATE Reservation SET BeginDateWanted="+r.getBeginDateWanted();
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
		Reservation r=null;
		sql="SELECT * FROM Reservation WHERE idReservation="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoGame g=new DaoGame(this.connect);
			r=new Reservation((Game)g.find(result.getInt("idGame")),result.getDate("BeginDateWanted").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
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
				r.add(new Reservation((Game)g.find(result.getInt("idGame")),result.getDate("BeginDateWanted").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return r;
		}

		return r;
	}

}
