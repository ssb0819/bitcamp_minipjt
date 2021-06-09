package com.model2.mvc.service.product;

import java.util.List;
import java.util.Map;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.common.Search;
import com.model2.mvc.common.UploadFile;

public interface ProductService {
	
	public int addProduct(Product product) throws Exception;

	public Map<String, Object> getProduct(int prodNo) throws Exception;

	public Map<String,Object> getProductList(Search search) throws Exception;

	public void updateProduct(Product product) throws Exception;
	
	public void deleteProduct(int prodNo) throws Exception;
	
	public void addFile(List<UploadFile> fileList) throws Exception;
	
}