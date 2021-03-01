package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class OpenChat implements Serializable{
	private String openChatId;
	private String userId;
	private String userName;
	private String itemId;
	private String text;
	private Timestamp date;


	public OpenChat() {

	}

	public String getOpenChatId() {
		return openChatId;
	}
	public void setOpenChatId(String openChatId) {
		this.openChatId = openChatId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
