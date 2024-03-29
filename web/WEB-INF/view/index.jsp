<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="resources/css/allStyles.css">
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>

<ul>
    <li>Companion List<a href="person/list">Page</a></li>
</ul>

<ul>
    <li>Gender<a href="person/listGenders">List</a></li>
</ul>
<ul>
    <li>Gender Add <a href="person/showAddGenderForm">Page</a></li>
</ul>
<div class="navigationWrapper">
    <a href="index.html" id="indexPage" class="urlNav">
        Home
    </a>
    <a href="person/showAddPersonForm" id="companionsPage" class="urlNav">
        Create Companions
    </a>
    <a href="person/list" id="currentCompanionsPage" class="urlNav">
        List Friends
    </a>
    <div href="courses" id="coursePage" class="urlNav">
        View Courses
    </div>
</div>
<div id="content">
    <div class="homeInfo">
        <p class="pageText">Isn't it just a drag not having a friend group that can make it super easy to pass your classes? How annoying is it that your
            friend group makes you HAVE to learn the content on your own to pass the class? Well look no further, for we here at JV Java are here to help! We
            take the effort out of school and help you hand pick your friend group in order to maximize your chance for success. Need a nerd or two to help you pass
            Distributed Java- We've got you! Want a jock to help you out in physical education, say no more!</p>
        <img src="resources/img/wctc.jpg" width="75%">
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js">
</script>
</html>
