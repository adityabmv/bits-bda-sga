<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course Management Portal</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 100px; }
        h1 { font-size: 2.5em; }
        a.button {
            display: inline-block;
            margin: 15px;
            padding: 10px 25px;
            font-size: 1.1em;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
        }
        a.button:hover { background-color: #45a049; }
    </style>
</head>
<body>
<h1>Course Management Portal</h1>
<a href="/students" class="button">View Students</a>
<a href="/courses" class="button">View Courses</a>
</body>
</html>
