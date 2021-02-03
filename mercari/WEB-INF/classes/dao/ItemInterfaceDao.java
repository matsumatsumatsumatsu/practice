package dao;

import java.util.List;

import bean.Item;

public interface ItemInterfaceDao {
	public void listing(Item item);
	public List getAllItems();
	public Item getItem(String itemName);
	public Item search(String itemName);
}
