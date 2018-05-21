<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hangman BILD-IT Hackaton</title>
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
        <label for="username">Username:</label>
        <input type="text" class="form-control" id="username">
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password">
    </div>
    <button type="button" class="btn btn-default"><a href="/login">Log in</a></button>
    </form>
    <button type="button" class="btn btn-default"><a href="/registration">Register</a></button>
</div>
</body>
</html>
