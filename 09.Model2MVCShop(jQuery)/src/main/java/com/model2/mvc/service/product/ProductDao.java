package com.model2.mvc.service.product;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.UploadFile;
import com.model2.mvc.service.domain.Product;

public interface ProductDao {
	
	public Product findProduct(int prodNo) throws Exception;
	
	public List<Product> getProductList(Search search) throws Exception;
	
	public int insertProduct(Product product) throws Exception;
	
	public void updateProduct(Product product) throws Exception;
	
	public void deleteProduct(int prodNo) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
	
	public void insertFile(List<UploadFile> fileList) throws Exception;
	
	public List<UploadFile> findUploadFile(int prodNo) throws Exception;

}
