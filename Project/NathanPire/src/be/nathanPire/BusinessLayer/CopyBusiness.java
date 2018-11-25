package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.util.List;

import be.nathanPire.dao.DaoCopy;
import be.nathanPire.pojo.Copy;
import be.nathanPire.pojo.Game;

public class CopyBusiness {
	private Connection conn;
	public CopyBusiness() {
		conn=GetConnection.getInstance().getConnection();
	}
	public List<Copy> getCopy(){
		return new DaoCopy(conn).getAll();
	}
	public Copy getCopyById(int id) {
		var dao=new DaoCopy(conn);
		var l=dao.getAll();
		Copy c=null;
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getID()==id) {
				c = l.get(i);
			}
		}
		return c;
	}
	public int getNumberOfCopy(Game g) {
		var dao=new DaoCopy(conn);
		var l=dao.getAll();
		int nbr = 0;
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getGame().getName()==g.getName()) {
				nbr++;
			}
		}
		return nbr;
	}
}
