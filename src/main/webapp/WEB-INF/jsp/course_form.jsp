<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <h2 class="mb-4">Add New Course</h2>

    <form action="/courses" method="post" class="card p-4 shadow-sm">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" name="title" value="${course.title}" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description" value="${course.description}" required>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
<jsp:include page="footer.jsp" />