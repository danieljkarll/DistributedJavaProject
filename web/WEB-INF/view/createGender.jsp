<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>here</p>
<form:form action="saveGender" modelAttribute="aGender" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>GenderName</label></td>
            <td><form:input path="gender"/>
                <form:errors path="gender" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="saveGender" class="saveGender"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
