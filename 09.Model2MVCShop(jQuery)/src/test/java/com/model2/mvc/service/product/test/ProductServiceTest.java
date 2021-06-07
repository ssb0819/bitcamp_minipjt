package com.model2.mvc.service.product.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.UploadFile;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
										"classpath:config/context-aspect.xml",
										"classpath:config/context-mybatis.xml",
										"classpath:config/context-transaction.xml"})
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Test
	public void testAddProduct() throws Exception{
		
		Product product = new Product();
		product.setProdName("FileTest");
		product.setManuDate("20210511");
		product.setProdDetail("test");
		product.setFileName("thumbnail_aaa");
		
		int prodNo = productService.addProduct(product);
		System.out.println(prodNo);
		
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginFileName("aaa");
		uploadFile.setSaveFileName("abc");
		uploadFile.setProdNo(prodNo);
		
		UploadFile uploadFile02 = new UploadFile();
		uploadFile02.setOriginFileName("bbb");
		uploadFile02.setSaveFileName("arg");
		uploadFile02.setProdNo(prodNo);
		
		List<UploadFile> fileList = new ArrayList<UploadFile>();	
		
		fileList.add(uploadFile);
		fileList.add(uploadFile02);
	
		productService.addFile(fileList);
		
		System.out.println("insert 완료");		
	}
	
	//@Test
	public void testGetProduct() throws Exception{
		
		Product product = productService.getProduct(10013);
		
		Assert.assertEquals("apple", product.getProdName());
		Assert.assertEquals("사과", product.getProdDetail());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals("2021-04-13", product.getRegDate()+"");
		
		Assert.assertNotNull(productService.getProduct(10000));
		Assert.assertNotNull(productService.getProduct(10001));		
	}
	
	//@Test
	public void testUpdateProduct() throws Exception{
		
		Product product = productService.getProduct(10080);		
		product.setProdName("updateproduct");
		product.setProdDetail("update");
		
		productService.updateProduct(product);
		product = productService.getProduct(10080);
		System.out.println(product);
	}
	
	//@Test
	public void testGetProductList() throws Exception{
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchKeyword("a");
		search.setSearchPriceMin("1000");
		search.setSearchPriceMax("5000");
		
		Map<String, Object> map = productService.getProductList(search);
		List<Product> list = (List<Product>)map.get("list");
		System.out.println(list.size());
		
	}
	
	//@Test
	public void testDeleteProduct() throws Exception{
		
		productService.deleteProduct(10080);
		System.out.println(" delete 완료");
		
	}
	
	//@Test
	public void testGetTotalCount() throws Exception{
		
		Search search = new Search();
		search.setSearchKeyword("testProduct");
		search.setSearchPriceMin("0");
		search.setSearchPriceMax("1000");
		
		Map<String, Object> map = productService.getProductList(search);
		System.out.println(map.size());
		System.out.println(map.get("totalCount"));
		
	}

}
