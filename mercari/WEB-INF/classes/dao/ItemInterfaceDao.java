package dao;

import java.util.List;

import bean.Item;

public interface ItemInterfaceDao {
	public void listing(Item item);
	public List getAllItems();
	public List getItem(String itemName);
	public Item search(String itemName);
}
