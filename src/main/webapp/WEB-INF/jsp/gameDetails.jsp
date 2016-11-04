<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Details</title>
</head>
<body>
	<h2>Game Details</h2>
	
	<table>
	<tr>
			<td>Package Id</td>
			<td>Game Name</td>
			<td>Package Name</td>
			<td>Game Category</td>
			<td>Game Url</td>
			<td>Game Cost</td>
		</tr>
	<c:forEach items="${gameInfo}" var="gameInfo">
		<tr>
			<td>${gamelist.packageId}</td>	
			<td>${gamelist.gameName}</td>	
			<td>${gameInfo.packageName}</td>
			<td>${gameInfo.gameCategory}</td>
			<td>${gameInfo.gameURL}</td>
			<td>${gameInfo.paid}</td>
		</tr>
		</c:forEach>
	</table>

	<br>

	<%-- <jsp:include page="similarGames.jsp"></jsp:include> --%>

</body>
</html>