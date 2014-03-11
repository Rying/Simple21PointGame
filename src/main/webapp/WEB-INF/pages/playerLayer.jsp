<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:forEach items="${playerCardPaths}" var="cardPath">
<img src = "${cardPath}" width = "100px" height="130px"/>
</c:forEach>
</html>