package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import be.nathanPire.dao.DaoPlayer;
import be.nathanPire.pojo.Player;

public class PlayerBusiness {
	private Connection conn;
	public PlayerBusiness() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:sqlserver://dbjavaprojectpire.database.windows.net:1433;database=Database;user=thelittlewozniak@dbjavaprojectpire;password={azerty1234@};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Player Login(String email,String password) {
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
