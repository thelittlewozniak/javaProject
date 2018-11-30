package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.nathanPire.dao.DaoReservation;
import be.nathanPire.pojo.Game;
import be.nathanPire.pojo.Reservation;

public class ReservationBusiness {
	private Connection conn;
	public ReservationBusiness() {
		conn=GetConnection.getInstance().getConnection();
	}
	public Reservation getReservation(Game g) {
		DaoReservation dao=new DaoReservation(conn);
		var list=dao.getAll();
		List<Reservation> list2=new ArrayList<Reservation>();
		if(list.size()>1) {
			Reservation unit=list.get(0);
			for(int i=1;i<list.size();i++) {
				var t=list.get(i).getGameWanted();
				if(list.get(i).getGameWanted().getID()==g.getID()) {
					list2.add(list.get(i));	
				}
			}
			list=list2;
			if(list.size()>1) {
				list2=new ArrayList<Reservation>();
				unit=list.get(0);
				for(int i=1;i<list.size();i++) {
					if(list.get(i).getPlayer().getAmountUnit()>unit.getPlayer().getAmountUnit()) {
						list2.clear();
						unit=list.get(i);
						list2.add(unit);	
					}
					else if(list.get(i).getPlayer().getAmountUnit()==unit.getPlayer().getAmountUnit()) {
						list2.add(list.get(i));
					}
				}
				list=list2;
				if(list.size()>1) {
					list2=new ArrayList<Reservation>();
					unit=list.get(0);
					for(int i=1;i<list2.size();i++) {
						if(list.get(i).getReservationDate().after(unit.getReservationDate())) {
							list2.clear();
							unit=list2.get(i);
							list2.add(unit);
						}
						else if(list.get(i).getReservationDate().equals(unit.getReservationDate())) {
							list2.add(list.get(i));
						}
					}
					list=list2;
					if(list.size()>1) {
						list2=new ArrayList<Reservation>();
						unit=list.get(0);
						for(int i=1;i<list2.size();i++) {
							if(list.get(i).getPlayer().getRegisterDate().isBefore(unit.getPlayer().getRegisterDate())) {
								list2.clear();
								unit=list2.get(i);
								list2.add(unit);
							}
							else if(list.get(i).getPlayer().getRegisterDate().equals(unit.getPlayer().getRegisterDate())) {
								list2.add(list.get(i));
							}
						}
						list=list2;
						if(list.size()>1) {
							list2=new ArrayList<Reservation>();
							unit=list.get(0);
							for(int i=1;i<list2.size();i++) {
								if(list.get(i).getPlayer().getBirthday().before(unit.getPlayer().getBirthday())) {
									list2.clear();
									unit=list2.get(i);
									list2.add(unit);
								}
								else if(list.get(i).getPlayer().getBirthday().equals(unit.getPlayer().getBirthday())) {
									list2.add(list.get(i));
								}
							}
							list=list2;
							if(list.size()>1) {
								Random rand = new Random();
								int index=rand.nextInt(list.size()-1);
								return list.get(index);
							}
							else
								return list.get(0);
						}
						else
							return list.get(0);
					}
					else
						return list.get(0);
				}
				else
					return list.get(0);
			}
			else
				return list.get(0);
		}
		else {
			return null;
		}
	}
}
