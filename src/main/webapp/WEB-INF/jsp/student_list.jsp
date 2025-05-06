<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Student List</h2>
        <a href="/students/new" class="btn btn-success">Add New Student</a>
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-bordered align-middle">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Courses</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>
                        <c:forEach var="c" items="${s.courses}">
                            <span class="badge bg-primary mb-1">${c.title}</span><br/>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="/students/edit/${s.id}" class="btn btn-sm btn-outline-primary">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp" />
