<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
	<html>
	<head>
		<title>User Profile</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/view/style.css">
	</head>
	<body>
		<div class="wrapper">
			<h1>Welcome</h1>
			<h3><%=request.getAttribute("username")%></h3>

			<div class="score">

			<table align="center" color="white">
				<th><h4>Last 5 games score: </h4></th>
				<c:forEach items="${scores}" var="score">
					<tr>
						<td>${score.getScore()}</td>
					</tr>
				</c:forEach>
            </table>
		</div>

			<a href="/newGame" class="btn btn-info" role="button">New game</a>
			<a href="/scoreboard" class="btn btn-info" role="button">Scoreboard</a>
            <a href="/logout" class="btn btn-info" role="button">Log Out</a>

            <c:if test="${username == 'admin'}">
                <a href="/admin/addWord" class="btn btn-info" role="button">Add Word</a>
                <a href="/admin/addUser" class="btn btn-info" role="button">Add User</a>
                <a href="/admin/deleteUser" class="btn btn-info" role="button">Delete User</a>
            </c:if>

		</div>

</div>
</body>
</html>