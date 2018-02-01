<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="players" type="java.util.List"--%>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<ul>
    <c:forEach items="${players}" var="player">
        <li>${player.name} ${player.surname}</li>
    </c:forEach>
</ul>
</body>
</html>
