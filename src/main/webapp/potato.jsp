<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ziemniaki</title>
</head>
<body>

<h1>Oto dział w ziemniakami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="ziemniak">
    Ilość: <input type="number" name="quantity" value="1" min="1" step="1" required>
    <input type="submit" value="Kup ziemniaka">
</form>

<br>
<form action="${pageContext.request.contextPath}/sell-from-basket" method="post">
    <input type="hidden" name="item" value="ziemniak">
    Ilość: <input type="number" name="quantity" value="1" min="1" step="1" required>
    <input type="submit" value="Odejmij ziemniaka">
</form>

<br>
<form action="${pageContext.request.contextPath}/index.jsp" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>
