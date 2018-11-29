package be.nathanPire.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Loan {
	private int ID;
	private Date beginDate;
	private Date endDate;
	private Player borrower;
	private Player lender;
	private Copy copy;
	//GET && SET
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate=beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate=endDate;
	}
	public Player getBorrower() {
		return borrower;
	}
	public void setBorrower(Player borrower) {
		this.borrower=borrower;
	}
	public Player getLender() {
		return lender;
	}
	public void setLender(Player lender) {
		this.lender=lender;
	}
	public Copy getCopy() {
		return copy;
	}
	public void setCopy(Copy copy) {
		this.copy=copy;
	}
	//Constructor
	public Loan(int ID,Date beginDate,Date endDate,Player borrower,Player lender,Copy copy) {
		this.ID=ID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.borrower=borrower;
		this.lender=lender;
		this.copy=copy;
	}
	public Loan(Date beginDate,Player borrower,Player lender,Copy copy) {
		this.beginDate=beginDate;
		this.endDate=null;
		this.borrower=borrower;
		this.lender=lender;
		this.copy=copy;

	}
}
