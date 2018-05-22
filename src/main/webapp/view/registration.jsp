<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register user</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="header">

</div>
<div class="wrapper">
    <h1>Registration</h1>
    <form method="post">
    <div class="form-group">
        <label for="username">Enter username:</label>
        <input type="email" class="form-control" id="username">
        <c:set var="salary" value="${2000*2}" /> --%>
        <c:if test="${salary > 2000 }" >
        <p>Ima se, moze se.</p>
        </c:if>

    </div>
    <div class="form-group">
        <label for="password">Enter password:</label>
        <input type="password" class="form-control" id="password">
    </div>
    <button type="button" class="btn btn-default">Register</button>
    </form>

</div>
</body>
</html>
