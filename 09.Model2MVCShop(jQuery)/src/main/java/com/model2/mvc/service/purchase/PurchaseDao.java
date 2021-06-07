package com.model2.mvc.service.purchase;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;


public interface PurchaseDao {
	
	
	public Purchase findPurchase1(int tranNo) throws Exception;
	
	public Purchase findPurchase2(int prodNo) throws Exception;
	
	public Purchase findPurchase(String sql) throws Exception;
	
	public List<Purchase> getPurchaseList(Search search, String buyerId) throws Exception;
	
	public List<Purchase> getSaleList(Search search) throws Exception;
	
	public void insertPurchase(Purchase purchase) throws Exception;
	
	public void updatePurchase(Purchase purchase) throws Exception;
	
	public void updateTranCode(Purchase purchase) throws Exception;
	
	public void deletePurchase(int tranNo) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
	

}
