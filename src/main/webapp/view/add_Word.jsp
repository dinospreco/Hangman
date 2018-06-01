<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
		<html>
		<head>
			<title>Super user</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
			<link rel="stylesheet" type="text/css" href="/view/style.css">
			</head>
		<body>
		
			<div class="wrapper">
				<h1>Add Word</h1>

				<form method="post">

                    <div class="form-group">
                        <label for="word">Add word:</label>
                        <input type="word" class="form-control" id="word" name="word">
                    </div>

                    <div class="form-group">
                        <label for="category">Add category:</label>
                        <input type="category" class="form-control" id="category" name="category">
                    </div>

			    <div class="row home">
                    <input type="submit" class="btn btn-info" value="Add Word"/>
			    </form>


                <a href="/profile" class="btn btn-info" role="button">Profile</a>
                </div>
		</div>
	</body>
	</html>