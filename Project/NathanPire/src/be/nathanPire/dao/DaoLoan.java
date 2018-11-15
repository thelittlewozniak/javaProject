package be.nathanPire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import be.nathanPire.pojo.Loan;

public class DaoLoan extends DAO<Loan> {

	private String sql;
	
	public DaoLoan(Connection conn) {
		super(conn);
		sql="";
	}

	@Override
	public boolean create(Loan obj) {
		sql="INSERT INTO Loan(BeginDate,EndDate,idCopy,Lender,Borrower) values("+obj.getBeginDate()+","+obj.getEndDate()+","+obj.getCopy().getID()+","+obj.getLender().getID()+","+obj.getBorrower().getID()+")";
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
	public boolean delete(Loan obj) {
		sql="DELETE FROM Loan where idCopy="+obj.getID();
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
	public boolean update(Loan obj) {
		sql="UPDATE Loan SET Lender="+obj.getLender().getID()+",Borrower="+obj.getBorrower().getID()+",idCopy="+obj.getCopy().getID()+",BeginDate="+obj.getBeginDate()+",EndDate="+obj.getEndDate()+" where idLoan="+obj.getID();
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
	public Loan find(int id) {
		Loan l=null;
		sql="SELECT * FROM Loan WHERE idLoan="+id;
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoCopy c=new DaoCopy(this.connect);
			DaoPlayer p=new DaoPlayer(this.connect);
			l=new Loan(result.getDate("BeginDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),result.getDate("EndDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),p.find(result.getInt("Borrower")),p.find(result.getInt("Lender")),c.find(result.getInt("idCopy")));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return l;
		}
		return l;
	}

	@Override
	public List<Loan> getAll() {
		List<Loan> l=new ArrayList<Loan>();
		sql="SELECT * FROM Loan";
		try {
			ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY
			      ).executeQuery(sql);
			DaoCopy c=new DaoCopy(this.connect);
			DaoPlayer p=new DaoPlayer(this.connect);
			while(result.next()) {
				var i=new Loan(result.getDate("BeginDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),result.getDate("EndDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),p.find(result.getInt("Borrower")),p.find(result.getInt("Lender")),c.find(result.getInt("idCopy")));
				l.add(i);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return l;
		}

		return l;
	}

}
