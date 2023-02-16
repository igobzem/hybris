<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <title>Stock2</title>
    <body>
        <h1>${SKU}</h1>
    <c:forEach var="name" items="${products}">
            <c:out value="${name}"/><br>
    </c:forEach>
    </body>
</html>