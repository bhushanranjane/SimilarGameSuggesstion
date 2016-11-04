<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Similar Games</title>
</head>
<body>

	<table>
		<tr>
			<td>Id</td>
			<td>${suggesstion.sequenceId}</td>
		</tr>
		<tr>
			<td>Game Name</td>
			<td>${suggesstion.gameName}</td>
		</tr>
		<tr>
			<td>Package Name</td>
			<td>${suggesstion.packageName}</td>
		</tr>
		<tr>
			<td>Game Icon</td>
			<td>${suggesstion.imageUrl}</td>
		</tr>
		<tr>
			<td>Game Ratings</td>
			<td>${suggesstion.gameRating}</td>
		</tr>
		<tr>
		<tr>
			<td>Game Cost</td>
			<td>${suggesstion.gameCost;}</td>
		</tr>
	</table>

</body>
</html>