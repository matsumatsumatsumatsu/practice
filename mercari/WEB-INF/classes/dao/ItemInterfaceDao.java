package dao;

import java.util.List;

import bean.Item;
import exception.IntegrationException;

public interface ItemInterfaceDao {
	public void listing(Item item) throws IntegrationException;
	public List getAllItems() throws IntegrationException;
	public List getItem(String key) throws IntegrationException;
	public String getItemName(String itemId) throws IntegrationException;
	public String  getSellerId(String itemId) throws IntegrationException;
	public Item manageStock(String itemId) throws IntegrationException;
	public List search(String keyword) throws IntegrationException;
	public void deleteItem(String itemid) throws IntegrationException;
	public void updateItem(Item i,String id) throws IntegrationException;
}