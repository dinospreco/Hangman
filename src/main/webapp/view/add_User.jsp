<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
		<html>
		<head>
			<title>Add user</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
			<link rel="stylesheet" type="text/css" href="/view/style.css">
		</head>
		<body>
		
			<div class="wrapper">
				<form method="post">
				<h1>Add User:</h1>
				<div class="form-group">
					<label for="username">Insert Username:</label>
					<input type="word" class="form-control" id="username" name="username">
				</div>
                    <div class="form-group">
                        <label for="password">Insert Password:</label>
                        <input type="word" class="form-control" id="password" name="password">
                    </div>
			</form>
<div class="row home">
                    <input type="submit" class="btn btn-info" value="Add User">

				<a href="/profile" class="btn btn-info" role="button">Profile</a>

</div>
		</div>
	</body>
	</html>