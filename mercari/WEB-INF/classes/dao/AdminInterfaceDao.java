package dao;

import java.util.List;

import exception.IntegrationException;

public interface AdminInterfaceDao {
	 public List getAdminPass(String adminName) throws IntegrationException;
}
