<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lost Game</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/view/style.css">
</head>
<body>

<div class="wrapper">
    <h1>Game lost</h1>
    <img src="/png/066.png"/>
    <h2>SOLUTION: <%=request.getAttribute("solution")%></h2>
    <div class="row home">
    <a href="/newGame" class="btn btn-info" role="button">New Game</a>
    <a href="/profile" class="btn btn-info" role="button">Profile</a>
</div>
</div>
</body>
</html>