<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <h2 class="mb-4">Edit Student</h2>

    <form action="/students/update/${student.id}" method="post" class="card p-4 shadow-sm">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${student.name}" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${student.email}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Courses</label>
            <div class="form-check">
                <c:forEach var="c" items="${courses}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="courseIds" id="course${c.id}" value="${c.id}"
                               <c:if test="${student.courses.contains(c)}">checked</c:if>>
                        <label class="form-check-label" for="course${c.id}">
                                ${c.title}
                        </label>
                    </div>
                </c:forEach>
            </div>
        </div>

        <button type="submit" class="btn btn-warning">Update</button>
    </form>
</div>
<jsp:include page="footer.jsp" />