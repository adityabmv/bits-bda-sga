<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Edit Course</title></head>
<body>
<h2>Edit Course</h2>
<form action="/courses/update/${course.id}" method="post">
    Title: <input type="text" name="title" value="${course.title}" /><br/>
    Description: <input type="text" name="description" value="${course.description}" /><br/><br/>
    <input type="submit" value="Update" />
</form>
</body>
</html>
