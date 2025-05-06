<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Course</title></head>
<body>
<h2>Add New Course</h2>
<form action="/courses" method="post">
    Title: <input type="text" name="title" value="${course.title}" /><br/>
    Description: <input type="text" name="description" value="${course.description}" /><br/><br/>
    <input type="submit" value="Save" />
</form>
</body>
</html>
