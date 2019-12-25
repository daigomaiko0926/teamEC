<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/myPage.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>マイページ画面</title>
</head>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<div id="top">
			<h1>マイページ画面</h1>
		</div>

		<div id="contents">
		<s:form action="PurchaseHistoryAction">
			<table class="vertical-list-table">

				<tr>
					<th scope="row"><s:label value="姓" /></th>
					<td><s:property value="userInfoDTO.familyName" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名" /></th>
					<td><s:property value="userInfoDTO.firstName" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="ふりがな" /></th>
					<td><s:property value="userInfoDTO.familyNameKana" /> <span>
					</span> <s:property value="userInfoDTO.firstNameKana" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="性別" /></th>
					<td><s:if test="userInfoDTO.sex == 0">男性</s:if> <s:else>女性</s:else></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="メールアドレス" /></th>
					<td><s:property value="userInfoDTO.email" /></td>
				</tr>
			</table>

			<tr>
				<td><s:submit value="購入履歴" class="submit" /></td>
			</tr>
		</s:form>
		</div>

	</div>

</body>
</html>