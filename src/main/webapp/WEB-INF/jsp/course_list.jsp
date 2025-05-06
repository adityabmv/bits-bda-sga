<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>All Courses</h2>
        <a href="/courses/new" class="btn btn-success">Add New Course</a>
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-bordered align-middle">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Enrolled Students</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.title}</td>
                    <td>${course.description}</td>
                    <td>
                        <c:forEach var="s" items="${course.students}">
                            <span class="badge bg-info text-dark mb-1">${s.name}</span><br/>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="/courses/edit/${course.id}" class="btn btn-sm btn-outline-primary">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp" />
