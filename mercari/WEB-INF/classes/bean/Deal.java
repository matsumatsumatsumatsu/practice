package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Deal implements Serializable {
	private String dealId;
	private String paymentId;
	private String depositId;
	private String itemId;
	private String dealState;
	private Timestamp timeLimit;

	public Deal() {}

	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getDepositId() {
		return depositId;
	}
	public void setDepositId(String depositId) {
		this.depositId = depositId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDealState() {
		return dealState;
	}
	public void setDealState(String dealState) {
		this.dealState = dealState;
	}
	public Timestamp getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Timestamp timeLimit) {
		this.timeLimit = timeLimit;
	}
}