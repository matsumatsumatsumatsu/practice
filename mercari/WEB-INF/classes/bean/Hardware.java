package bean;

import java.io.Serializable;

public class Hardware implements Serializable {
	private String hardwareId;
	private String hardware;

	public Hardware() {}

	public String getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getHardware() {
		return hardware;
	}
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
}
