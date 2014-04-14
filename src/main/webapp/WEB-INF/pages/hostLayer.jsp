<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:forEach items="${hostCardPaths}" var="cardPath">
<img src = "<c:url value='${cardPath}'/>" width = "100px" height="130px"/>
</c:forEach>
</html>