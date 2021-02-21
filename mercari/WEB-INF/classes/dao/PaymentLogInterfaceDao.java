package dao;

import java.util.List;

import bean.PaymentLog;
import exception.IntegrationException;

public interface PaymentLogInterfaceDao {
	public String insertPaymentLog(PaymentLog payment) throws IntegrationException;
	public List getAllPaymentLogs(String paymentLogId) throws IntegrationException;
	public String getBuyerId(String itemId) throws IntegrationException;
	public String getSellerId(String itemId) throws IntegrationException;
}
