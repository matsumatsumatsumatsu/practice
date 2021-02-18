package dao;

import java.util.List;

import bean.PaymentLog;
import exception.IntegrationException;

public interface PaymentLogInterfaceDao {
	public void insertPaymentLog(PaymentLog payment) throws IntegrationException;
	public List getAllPaymentLogs(String paymentLogId) throws IntegrationException;
}
