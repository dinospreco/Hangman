<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
	<html>
	<head>
		<title>Game</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<style><%@include file="style.css"%></style>

	</head>
	<body>
		<div class="header">

		</div>

        <img src="/image">

		<div class="wrapper">

            <div class="form-group">
				<form method="post">
					<label for="word">Insert word or letter:</label>
					<input type="word" class="form-control" id="word" name="word">
                    <div class="btn btn-info">Enter</div>
				</form>
			</div>
			<div class="form-group">
				<h3>Solution:</h3>
				<h3>${solution}</h3>
				<h4>Used Letters:</h4>
				<h3>${usedLetters}</h3>
			</div>

        </div>
</body>
</html>