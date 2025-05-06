<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>
<form action="/students/update/${student.id}" method="post">
    Name: <input type="text" name="name" value="${student.name}" /><br/>
    Email: <input type="email" name="email" value="${student.email}" /><br/>
    Courses:<br/>
    <c:forEach var="c" items="${courses}">
        <input type="checkbox" name="courseIds" value="${c.id}"
               <c:if test="${student.courses.contains(c)}">checked</c:if>
        /> ${c.title}<br/>
    </c:forEach>
    <br/>
    <input type="submit" value="Update" />
</form>
</body>
</html>
