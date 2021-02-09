package bean;

import java.io.Serializable;

public class Notice implements Serializable{
	private String noticeId;
	private String comment;

	public Notice() {

	}

	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
