package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import be.nathanPire.dao.DaoLoan;
import be.nathanPire.dao.DaoPlayer;
import be.nathanPire.dao.DaoReservation;
import be.nathanPire.pojo.Copy;
import be.nathanPire.pojo.Loan;
import be.nathanPire.pojo.Player;
import be.nathanPire.pojo.Reservation;

	public class LoanBusiness {
		private Connection conn;
		public LoanBusiness() {
			conn=GetConnection.getInstance().getConnection();
		}
		public Boolean Loaned(Copy c) {
			DaoLoan dao=new DaoLoan(conn);
			List<Loan> loans=dao.getAll();
			for(int i=0;i<loans.size();i++) {
				if(loans.get(i).getCopy().getID()==c.getID()) {
					return loans.get(i).getEndDate()==null?true : false;
					}
				}
			return false;
		}
		public void makeALoan(Reservation r,Player p,Copy c) {
			DaoLoan dao=new DaoLoan(conn);
			DaoReservation daoR=new DaoReservation(conn);
			Loan l=new Loan(new Date(),r.getPlayer(),p,c);
			dao.create(l);
			daoR.delete(r);
		}
		public void finishALoan(Player p,Copy c) {
			DaoLoan dao=new DaoLoan(conn);
			List<Loan> l=dao.getAll();
			Loan loan;
			for(int i=0;i<l.size();i++) {
				if(l.get(i).getCopy().getID()==c.getID() && l.get(i).getEndDate()==null) {
					loan=l.get(i);
					loan.setEndDate(new Date());
					dao.update(loan);
				}
			}
		}
		public List<Loan> getLoanByPlayer(Player p){
			DaoLoan dao=new DaoLoan(conn);
			List<Loan> l=dao.getAll();
			for(int i=0;i<l.size();i++) {
				if(l.get(i).getBorrower().getID()!=p.getID()) {
					l.remove(l.get(i));
				}
			}
			return l;
		}
}
