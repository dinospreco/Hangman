<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
	<html>
	<head>
		<title>Game</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/view/style.css">

	</head>
	<body>
		<div class="header">

		</div>



		<div class="wrapper">

			<img src="${image}"/>

            <div class="form-group">
				<form method="post">
					<label for="word">Insert word or letter:</label>
					<input type="word" class="form-control" id="word" name="word" autofocus>
                    <input type="submit" class="btn btn-info" value="Enter">
				</form>
			</div>
			<div class="form-group">
				<h3>Solution:</h3>
				<h3><%=request.getAttribute("solution")%></h3>
				<h3>Missed Letters:</h3>
				<h3><%=request.getAttribute("usedLetters")%></h3>
				<h3>Current Score: </h3>
				<h3><%=request.getAttribute("score")%></h3>
                <h3>Category:</h3>
                <h3>${category}</h3>
			</div>
            <a href="/newGame" class="btn btn-info">New Game</a>
            <a href="/profile" class="btn btn-info">Profile</a>

        </div>
</body>
</html>