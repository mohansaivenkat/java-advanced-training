<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
</head>

<body>

    <c:forEach var="name" items="${msg}">
    	<h1>${name} Welcome to Spring Boot</h1>
    </c:forEach>

</body>

</html>