package dao;

import java.util.List;

import bean.Item;

public interface ItemInterfaceDao {
	public void listing(Item item);
	public List getAllItems();
}
