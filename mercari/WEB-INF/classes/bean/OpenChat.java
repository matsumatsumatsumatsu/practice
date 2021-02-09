package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class OpenChat implements Serializable{
	private String openChatId;
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
}
