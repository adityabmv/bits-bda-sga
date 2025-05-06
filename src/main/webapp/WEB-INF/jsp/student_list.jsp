<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Student List</title></head>
<body>
<h2>Student List</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Courses</th></tr>
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
        </tr>
    </c:forEach>
</table>
</body>
</html>
