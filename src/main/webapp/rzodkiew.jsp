<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rzodkiew</title>
</head>
<body>

<h1>Oto dział z rzodkwią:</h1>

<form action="${pageContext.request.contextPath}/basket" method="post">
    <input type="hidden" name="item" value="rzodkiew">
    <input type="submit" value="Kup rzodkiew">
</form>

<form action="${pageContext.request.contextPath}/" method="get">
    <input type="submit" value="Rozmyśliłem się">
</form>

</body>
</html>