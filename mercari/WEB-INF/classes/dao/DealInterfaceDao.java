package dao;

import java.util.List;

import bean.Deal;
import exception.IntegrationException;

public interface DealInterfaceDao {
	public void  insertDeal(Deal deal) throws IntegrationException;
	public List getDealInfo(String dealId) throws IntegrationException;
}
