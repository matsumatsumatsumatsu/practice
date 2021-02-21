package dao;

import java.util.List;

import bean.Deal;
import exception.IntegrationException;

public interface DealInterfaceDao {
	public void  insertDeal(Deal deal) throws IntegrationException;
	public List getAllDeals(String dealId, String dealState) throws IntegrationException;
	public List getSellAllDeals(String userId, String dealState) throws IntegrationException;
	public List getDeal(String dealId) throws IntegrationException;
	public void changeState(String dealId,String state) throws IntegrationException;
	public void updatePaymentLog(Deal d,String dealId) throws IntegrationException;
	public String getBuyerId(String dealId) throws IntegrationException;
	public String getItemId(String dealId) throws IntegrationException;
}
