package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.UploadFile;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.ProductDao;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public int addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub			
		return productDao.insertProduct(product);
	}

	@Override
	public Map<String, Object> getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		List<UploadFile> list = productDao.findUploadFile(prodNo);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("product", productDao.findProduct(prodNo));
		map.put("uploadFiles", list);		
		
		return map;
	}

	@Override
	public Map<String, Object> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list= productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", totalCount);
		
		return map;
	}

	@Override
	public void updateProduct(Product productVO) throws Exception {
		// TODO Auto-generated method stub
		productDao.updateProduct(productVO);		
	}

	@Override
	public void deleteProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		productDao.deleteProduct(prodNo);
	}

	@Override
	public void addFile(List<UploadFile> fileList) throws Exception {
		// TODO Auto-generated method stub
		productDao.insertFile(fileList);
	}		

}
