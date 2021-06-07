package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
										"classpath:config/context-aspect.xml",
										"classpath:config/context-mybatis.xml",
										"classpath:config/context-transaction.xml" })
public class PurchaseServiceTest {
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	//@Test
	public void testAddPurchase() throws Exception{
		
			Purchase purchase = new Purchase();
			Product product = new Product();
			User user = new User();
			
			user.setUserId("user17");
			
			product.setProdNo(10007);
			product.setProdName("test");
			product.setPrice(99999);
			
			purchase.setBuyer(user);
			purchase.setPurchaseProd(product);
			purchase.setDivyAddr("test");
			purchase.setReceiverPhone("9999");
			purchase.setPaymentOption("1");
			
			purchaseService.addPurchase(purchase);
	}
	
	@Test
	public void testGetSaleList() throws Exception{
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(5);
		//search.setSearchCondition("1");
		//search.setSearchKeyword("a");
		
		Map<String, Object> map = purchaseService.getSaleList(search);
		List<Purchase> list = (List<Purchase>)map.get("list");
		for(Purchase p : list) {
			System.out.println(p);
		}
		System.out.println("list.size : "+list.size());
		
	}
	

}
