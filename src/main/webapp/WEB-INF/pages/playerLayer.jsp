<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<p>
<c:forEach items="${playerCardPaths}" var="cardPath">
<img src = "<c:url value='${cardPath}'/>" alt = "card" width = "100px" height="130px"/>
</c:forEach>
</p>
</html>