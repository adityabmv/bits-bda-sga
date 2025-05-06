<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Student List</title></head>
<body>
<h2>Student List</h2>
<a href="/students/new">Add New Student</a>
<br/><br/>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Courses</th><th>Action</th></tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>
                <c:forEach var="c" items="${s.courses}">
                    ${c.title}<br/>
                </c:forEach>
            </td>
            <td>
                <a href="/students/edit/${s.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
