<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

	<html>
		<head>
			<title>Hangman BILD-IT Hackaton</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
            <link rel="stylesheet" type="text/css" href="/view/style.css">
		</head>
		<body>
			<div class="header">

        </div>
        <div class="wrapper">
            <h1>Hangman</h1>
            <form method="post" action="/login">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="user" class="form-control" id="username" name="username">
                </div>
 
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <input type="submit" class="btn btn-info" value="Log in"/>
            </form>
            <a href="/registration" class="btn btn-info" role="button">Register</a>
        </div>
    </body>
</html>