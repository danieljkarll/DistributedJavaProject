<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        Gender
    </tr>
    <c:forEach var="tempGender" items="${genders}">

        <tr>
            <td>
            <td>${tempGender.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
