package be.nathanPire.pojo;

import java.time.LocalDateTime;

public class Loan {
	private LocalDateTime beginDate;
	private LocalDateTime endDate;
	private Borrower borrower;
	private Lender lender;
	public LocalDateTime getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(LocalDateTime beginDate) {
		this.beginDate=beginDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate=endDate;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower=borrower;
	}
	public Lender getLender() {
		return lender;
	}
	public void setLender(Lender lender) {
		this.lender=lender;
	}
	//Constructor
	public Loan(LocalDateTime beginDate,LocalDateTime endDate,Borrower borrower,Lender lender) {
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.borrower=borrower;
		this.lender=lender;
	}
}
