<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
		<html>
		<head>
			<title>Register user</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
			<link rel="stylesheet" type="text/css" href="/view/style.css">
		</head>
		<body>
		
			<div class="wrapper">
				<h1>Registration</h1>

				<form action="/registration" method="post">
				<div class="form-group">
					<label for="username">Enter username:</label>
					<input type="user" class="form-control" id="username" name="username">
				</div>
				<div class="form-group">
					<label for="password">Enter password:</label>
					<input type="password" class="form-control" id="password" name="password">
				</div>
				</form>
				<div class="row home">
					<input type="submit" class="btn btn-info" value="Register">

				<a href="/" class="btn btn-info" role="button">Home</a>
</div>

			</form>

		</div>
	</body>
	</html>