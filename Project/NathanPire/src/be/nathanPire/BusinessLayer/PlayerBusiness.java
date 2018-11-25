package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import be.nathanPire.dao.DaoPlayer;
import be.nathanPire.dao.DaoReservation;
import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Player;
import be.nathanPire.pojo.Reservation;

public class PlayerBusiness {
	private Connection conn;
	public PlayerBusiness() {
		conn=GetConnection.getInstance().getConnection();
	}
	public Player login(String email,String password) {
		if(email!=null && password!=null) {
			List<Player> listP= new DaoPlayer(conn).getAll();
			for(int i=0;i<listP.size();i++) {
				if(listP.get(i).getEmail().equals(email)) {
					if(listP.get(i).getPassword().equals(password)){
						return listP.get(i);
					}
				}
			}
		}
		return null;
	}
	public boolean register(String email,String password,String name,String firstname,String birthday,String address) {
		if(email!=null && password!=null && name!=null && birthday!=null && address!=null) {
			Date d = null;
			try {
				d = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			Player p=new Player(name,firstname,email,password,address,d);
			if(new DaoPlayer(conn).create(p)) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public Player makeAReservation(Player p,String dateWanted,Game g) {
		if(g!=null && p!=null && !dateWanted.isEmpty()) {
			Date d = null;
			try {
				d = new SimpleDateFormat("dd/MM/yyyy").parse(dateWanted);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			DaoReservation dao=new DaoReservation(conn);
			var r=new Reservation(g,d);
			r.setPlayer(p);
			dao.create(r);
			p.getReservation().add(r);
			return p;
		}
		else
			return null;
	}
	public Player removeAReservation(Player p,int idres) {
		if(idres!=0 && p!=null) {
			DaoReservation dao=new DaoReservation(conn);
			var r=dao.find(idres);
			r.setPlayer(null);
			Boolean t=p.getReservation().remove(r);
			dao.delete(r);
			return p;
		}
		else
			return null;
	}
}
