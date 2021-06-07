<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="EUC-KR">
<title>회원탈퇴</title>
<script>
function fncDeleteUser() {	
	opener.window.location.href='/user/deleteUser';	
	window.close();
}
</script>
</head>
<body>
<table>
	<tr align="center">
	탈퇴 후 회원정보 복원은 불가능합니다.
	탈퇴하시겠습니까?
	</tr>

	<tr>
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top:10px;">
	<tr>
		<td align="center">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/> 
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncDeleteUser();">탈퇴</a>
					</td>						
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
					<td width="30"></td>					
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:window.close();">취소</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
	</tr>
</table>

</body>
</html>