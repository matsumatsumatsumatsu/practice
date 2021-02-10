package dao;

import java.util.List;

import exception.IntegrationException;

public interface HardwareInterfaceDao {
	public List getAllHardware() throws IntegrationException;
	public List getHardware(String key, String id)throws IntegrationException;

}
