package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import be.nathanPire.dao.DaoPlayer;
import be.nathanPire.pojo.Player;

public class PlayerBusiness {
	private Connection conn;
	public PlayerBusiness() {
		
	}
	public Player Login(String email,String password) {
		if(email!=null && password!=null) {
			List<Player> listP= new DaoPlayer(conn).getAll();
			for(int i=0;i<listP.size();i++) {
				if(listP.get(i).getEmail()==email) {
					if(listP.get(i).getPassword()==password){
						return listP.get(i);
					}
				}
			}
		}
		return null;
	}
	public Player Register(String email,String password,String name,String firstname,String birthday,String address) {
		if(email!=null && password!=null && name!=null && birthday!=null && address!=null) {
			Date d = null;
			try {
				d = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			Player p=new Player(name,firstname,email,password,address,d);
			if(new DaoPlayer(conn).create(p)) {
				return p;
			}
			else
				return null;
		}
		else
			return null;
	}
}
