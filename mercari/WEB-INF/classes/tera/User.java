
package tera;

import java.io.Serializable;

public class User implements Serializable{
	private String user_id;
	private String user_name;
	private String real_name;
	private String address;
	private String tell;
	private String mail;
	private String profile;
	private String point;
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getuser_id() {
			System.out.println("user_id");
			System.out.println(user_id);
		return user_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public void setPid(String user_id) {
		System.out.println("user_id");
		System.out.println(user_id);
		this.user_id = user_id;
	}
}


//商品を意味するBeanです。