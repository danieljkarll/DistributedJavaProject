<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>here</p>
    <form:form action="save" modelAttribute="aPerson" enctype="multipart/form-data">
        <table>
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name"/>
                    <form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>SelfieFileName</label></td>
                <td><form:input path="selfiefile"/>
                    <form:errors path="selfiefile" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Bio</label></td>
                <td><form:input path="bio"/>
                    <form:errors path="bio" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
