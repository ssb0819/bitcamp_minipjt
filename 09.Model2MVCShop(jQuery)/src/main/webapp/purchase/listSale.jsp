<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.domain.*" %>

    
<!DOCTYPE html>
<html>
<head>
	<title>
		상품 관리
	</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">

function fncGetList(currentPage){
	document.getElementById("currentPage").value = currentPage;
	document.detailForm.submit();
}

</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/purchase/listSale?menu=manage" method="post"> 

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
							상품 관리					
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0" ${!empty search.searchCondition && search.searchCondition == 0 ? "selected" : "" }>상품번호</option>
				<option value="1" ${!empty search.searchCondition && search.searchCondition == 1 ? "selected" : "" }>상품명</option>
			</select>
			<input type="text" name="searchKeyword"  value="${ search.searchKeyword }" class="ct_input_g" style="width:200px; height:19px" />
		</td>
	
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetList('1');">검색</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >전체 ${resultPage.totalCount} 건수, 현재 ${resultPage.currentPage} 페이지</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">상품번호</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">가격</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">등록일</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">현재상태</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">주문일</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송요청일</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>	
	<c:set var="i" value="0" />
	<c:forEach var="purchase" items="${list}" >
		<c:set var="i" value="${i+1}" />	
		<tr class="ct_list_pop">
			<td align="center">
				<c:if test="${!empty purchase.tranCode }">
					<a href="/purchase/getPurchase?tranNo=${purchase.tranNo}&menu=manage&currentPage=${search.currentPage}">${i}</a>
				</c:if>
				<c:if test="${empty purchase.tranCode }">
					${i}
				</c:if>
			</td>
			<td></td>
			<td align="left">${purchase.purchaseProd.prodNo}</td>
			<td></td>
			<td align="left">
				<c:if test="${empty purchase.tranCode }">
					<a href="/product/updateProduct/${purchase.purchaseProd.prodNo}/${search.currentPage}">${purchase.purchaseProd.prodName}</a>
				</c:if>
				<c:if test="${!empty purchase.tranCode }">
					${purchase.purchaseProd.prodName}
				</c:if>
			</td>
			<td></td>
			<td align="left">${purchase.purchaseProd.price}</td>
			<td></td>
			<td align="left">${purchase.purchaseProd.regDate}</td>
			<td></td>		
			<td align="left">
			<c:choose>
				<c:when test="${ empty purchase.tranCode }">
					판매중
				</c:when>
				<c:when test="${ purchase.tranCode.trim() == 1 }">
					구매완료
					<a href="/purchase/updateTranCodeByProd?prodNo=${purchase.purchaseProd.prodNo}&tranCode=2&currentPage=${search.currentPage}">배송하기</a>
				</c:when>
				<c:when test="${ purchase.tranCode.trim() == 2 }">
					배송중
				</c:when>
				<c:when test="${ purchase.tranCode.trim() == 3 }">
					배송완료
				</c:when>
			</c:choose>
			</td>
			<td></td>
			<td align="left">${purchase.orderDate}</td>
			<td></td>
			<td align="left">${purchase.divyDate}</td>			
		</tr>
	</c:forEach>
	<tr>
		<td colspan="15" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
			<input type="hidden" id="currentPage" name="currentPage" value=""/>
			<jsp:include page="../common/pageNavigator.jsp"/>
    	</td>
	</tr>
</table>
<!--  페이지 Navigator 끝 -->

</form>

</div>
</body>
</html>