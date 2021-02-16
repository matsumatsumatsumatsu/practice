package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Deal implements Serializable {
	private String dealId;
	private String beforePaymentId;
	private String afterPaymentId;
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
	public String getBeforePaymentId() {
		return beforePaymentId;
	}
	public void setBeforePaymentId(String beforePaymentId) {
		this.beforePaymentId = beforePaymentId;
	}
	public String getAfterPaymentId() {
		return afterPaymentId;
	}
	public void setAfterPaymentId(String afterPaymentId) {
		this.afterPaymentId = afterPaymentId;
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
