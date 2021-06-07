package com.model2.mvc.web.purchase;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;


//==> 상품관리 Controller
@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {
	
	///Field
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	//setter Method 구현 않음
		
	public PurchaseController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml 참조 할것
	//==> 아래의 두개를 주석을 풀어 의미를 확인 할것
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	@RequestMapping("/addPurchase")
	public String addPurchase( @ModelAttribute("purchase") Purchase purchase) throws Exception {

		System.out.println("/addPurchase 시작");
		String tempManuDate = purchase.getDivyDate().replaceAll("-", "");
		purchase.setDivyDate(tempManuDate);
		
		//Business Logic
		purchaseService.addPurchase(purchase);
		//model.addAttribute(purchase);
		
		return "forward:/purchase/addPurchase.jsp";
	}
	
	@RequestMapping("/listSale")
	public String getSaleList( @ModelAttribute("search") Search search , Model model) throws Exception{
		
		System.out.println("/listSale 시작");		
		
		System.out.println("search 검색어 : "+search.getSearchKeyword());
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=purchaseService.getSaleList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/purchase/listSale.jsp";
	}
	
	@RequestMapping("/getPurchase")
	public String getPurchase( ) throws Exception {
				
		return "";
	}
	
	@RequestMapping("/updatePurchaseView")
	public String updatePurchaseView( ) throws Exception{
	
		return "";
	}
	
	@RequestMapping("/updatePurchase")
	public String updatePurchase( ) throws Exception{
		
		return "";
	}
	
	
	@RequestMapping("/listPurchase")
	public String listPurchase() throws Exception{
		
		
		return "";
	}
	
	
	
}