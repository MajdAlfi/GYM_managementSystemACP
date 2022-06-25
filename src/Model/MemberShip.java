package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class MemberShip implements Serializable {
	// (ClientID), (startDate), (endDate), (accessToPool), (payment), (courseT).
	public int clientID;
	public LocalDate startDate;
	public LocalDate endDate;
	public boolean accessToPool;
	public double payment;
	public String courseT;

	public int getClientID() {
		return clientID;
	}

	public MemberShip(int clientID, LocalDate startDate, LocalDate endDate, boolean accessToPool, double payment,
			String courseT) {
		super();
		this.clientID = clientID;
		this.endDate = endDate;
		this.startDate = startDate;
		this.accessToPool = accessToPool;
		this.payment = payment;
		this.courseT = courseT;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public LocalDate getstartDate() {
		return startDate;
	}

	public void setstartate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isAccessToPool() {
		return accessToPool;
	}

	public void setAccessToPool(boolean accessToPool) {
		this.accessToPool = accessToPool;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getCourseT() {
		return courseT;
	}

	public void setCourseT(String courseT) {
		this.courseT = courseT;
	}

	@Override
	public String toString() {
		return "MemberShip [clientID=" + clientID + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", accessToPool=" + accessToPool + ", payment=" + payment + ", courseT=" + courseT + "]";
	}

}
