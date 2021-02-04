package dao;

import java.util.List;

import bean.Item;
import exception.IntegrationException;

public interface ItemInterfaceDao {
	public void listing(Item item) throws IntegrationException;
	public List getAllItems() throws IntegrationException;
	public List getItem(String itemName) throws IntegrationException;
	public Item manageStock(String itemId) throws IntegrationException;
	//public Item search(String itemName);
	//public Item category(String categoryId);
	//public Item sort(String col, String order);
}