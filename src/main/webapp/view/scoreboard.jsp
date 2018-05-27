<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.ScoreBoardDTO" %>

<!DOCTYPE html>
	<html>
	<head>
		<title>Scoreboard</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="/view/style.css">
	</head>
	<body>
		<div class="wrapper">
			<h1>Scoreboard</h1>
			<div class="score">
			<table align="center" color="white">
				<th></th>
				<th>Username</th>
				<th>Score</th>
				<c:forEach items="${scores}" var="score" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${score.getUsername()}</td>
						<td>${score.getScore()}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
			
			
			<a href="/game" class="btn btn-info" role="button">New game</a>
			<a href="/profile" class="btn btn-info" role="button">Back</a>

		</div>

	</form>

</div>
</body>
</html>