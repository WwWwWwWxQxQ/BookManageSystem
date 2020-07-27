package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class BorrowRecord {
	private int bookId;
	private int userId;
	private LocalDateTime borrowTime;
	private LocalDateTime returnTime;
	private double payment;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(LocalDateTime borrowTime) {
		this.borrowTime = borrowTime;
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public BorrowRecord(int bookId, int userId, LocalDateTime borrowTime, LocalDateTime returnTime, double payment) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return " 于 " + borrowTime
				+ " 借阅了 " + bookId
				+ "号书, 归还时间为 " + (returnTime==null ? "尚未归还" : returnTime)
				+ ", 应付 ¥" + payment;
	}

}
