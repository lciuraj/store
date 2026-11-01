<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jabłka</title>
</head>
<body>

<h1>Oto dział w jabłkami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="jabłko">
    Ilość: <input type="number" name="quantity" value="1" min="1" step="1" required>
    <input type="submit" value="Kup jabłko">
</form>

<br>
<form action="${pageContext.request.contextPath}/index.jsp" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>
