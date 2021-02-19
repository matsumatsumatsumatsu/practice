package dao;

import java.util.List;

import bean.Deal;
import exception.IntegrationException;

public interface DealInterfaceDao {
	public void  insertDeal(Deal deal) throws IntegrationException;
	public List getAllDeals(String dealId) throws IntegrationException;
	public List getSellAllDeals(String userId) throws IntegrationException;
	public List getDeal(String dealId) throws IntegrationException;
}
