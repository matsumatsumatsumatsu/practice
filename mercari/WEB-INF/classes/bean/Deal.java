package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Deal implements Serializable {
	private String dealId;
	private String beforePaymentId;
	private String afterPaymentId;
	private String itemId;
	private String itemName;
	private String itemImage;
	private String sellerId;
	private int term;
	private String dealState;
	private Timestamp timeLimit;
	private String userId;
	private String userState;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return itemImage
	 */
	public String getItemImage() {
		return itemImage;
	}

	/**
	 * @param itemImage セットする itemImage
	 */
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	/**
	 * @return sellerId
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId セットする sellerId
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term セットする term
	 */
	public void setTerm(int term) {
		this.term = term;
	}
}
