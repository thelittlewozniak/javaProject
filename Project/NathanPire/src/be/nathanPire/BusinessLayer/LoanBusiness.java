package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import be.nathanPire.dao.DaoLoan;
import be.nathanPire.dao.DaoPlayer;
import be.nathanPire.pojo.Copy;
import be.nathanPire.pojo.Loan;

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
}
