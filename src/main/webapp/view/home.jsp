<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Hangman BILD-IT Hackaton</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
             <link rel="stylesheet" type="text/css" href="style.css">
        </head>
        <body>
            <div class="header">
 
        </div>
        <div class="wrapper">
            <h1>Hangman</h1>
            <form method="post">
                <div class="form-group">
                    <label for="user">Username:</label>
                    <input type="user" class="form-control" id="user">
                </div>
 
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd">
                </div>
                <a href="profile.html" class="btn btn-info" role="button">Log in</a>
                <a href="/registration" class="btn btn-info" role="button">Register</a>
            </form>
        </div>
    </body>
</html>