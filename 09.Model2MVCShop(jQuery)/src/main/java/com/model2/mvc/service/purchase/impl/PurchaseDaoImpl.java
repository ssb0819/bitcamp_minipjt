package com.model2.mvc.service.purchase.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public Purchase findPurchase1(int tranNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase findPurchase2(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase findPurchase(String sql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> getPurchaseList(Search search, String buyerId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<Purchase> getSaleList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("PurchaseMapper.getSaleList", search);
	}
	

	@Override
	public void insertPurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("PurchaseMapper.insertPurchase", purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePurchase(int tranNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", search);
	}


}
