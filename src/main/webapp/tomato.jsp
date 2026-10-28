<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pomidory</title>
</head>
<body>

<h1>Oto dział z pomidorami:</h1>

<form action="${pageContext.request.contextPath}/add-to-basket" method="post">
    <input type="hidden" name="item" value="pomidor">
    <input type="submit" value="Kup pomidora">
</form>

<br>
<form action="${pageContext.request.contextPath}/index.jsp" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>
