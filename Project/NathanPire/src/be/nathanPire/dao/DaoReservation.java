package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
