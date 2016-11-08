<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Similar Games</title>
</head>
<body>
	<table>
	<tr>
			<td>Sequence Id</td>
			<td>Game Name</td>
			<td>Package Name</td>
			<td>Image Url</td>
			<td>Game Rating</td>
			<td>Game Cost</td>
		</tr>
		<c:forEach items="${suggesstion}" var="suggesstion">
		<tr>
			<td>${suggesstion.sequenceId}</td>	
			<td>${suggesstion.gameName}</td>	
			<td>${suggesstion.packageName}</td>
			<td>${suggesstion.imageUrl}</td>
			<td>${suggesstion.gameRating}</td>
			<td>${suggesstion.gameCost}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>