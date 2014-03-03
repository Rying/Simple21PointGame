<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:forEach items="${game.playerCards}" var="cardPath">
<img src = "${cardPath}" width = "100" height="130px"/>
</c:forEach>
</html>