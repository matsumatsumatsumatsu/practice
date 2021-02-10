package dao;

import java.util.List;

import exception.IntegrationException;

public interface CategoryInterfaceDao {
	public List getAllCategory() throws IntegrationException;
	public List getCategory(String key, String id)throws IntegrationException;
}
