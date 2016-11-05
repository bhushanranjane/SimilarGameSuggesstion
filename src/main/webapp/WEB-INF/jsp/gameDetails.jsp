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
<h1>Game Details</h1>
<table>
	<tr>
			<td>Package Id</td>
			<td>Game Name</td>
			<td>Package Name</td>
			<td>Game Category</td>
			<td>Game Url</td>
			<td>Game Cost</td>
		</tr>
	<c:forEach items="${game}" var="game">
		<tr>
			<td>${game.packageId}</td>	
			<td>${game.gameName}</td>	
			<td>${game.packageName}</td>
			<td>${game.gameCategory}</td>
			<td>${game.gameURL}</td>
			<td>${game.paid}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<jsp:include page="similarGames.jsp"></jsp:include>
</body>
</html>