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
        <th></th>
        <th>Name</th>
        <th>Description</th>
        <th>SelfieFileName</th>
        <th>Bio</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="tempPerson" items="${persons}">

        <tr>
            <td>
            <td>${tempPerson.name}</td>
            <td>${tempDonut.bio}</td>
            <td>${tempDonut.selfiefilename}</td>
            <td>${tempDonut.genderid}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
