<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Won Game</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <style><%@include file="style.css"%></style>
</head>
<body>

<div class="wrapper">
    <h1>Congratulations, you won the game</h1>
    <h2>WORD: <%=request.getAttribute("word")%></h2>
    <h2>SCORE: <%=request.getAttribute("score")%></h2>
    <a href="/newGame" class="btn btn-info" role="button">New Game</a>
    <a href="/profile" class="btn btn-info" role="button">Profile</a>
</div>
</body>
</html>
