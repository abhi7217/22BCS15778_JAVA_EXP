<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head><title>Student Portal</title></head>
<body>
    <form action="attendanceServlet" method="post">
        Student ID: <input type="text" name="studentID" /><br />
        Attendance: <input type="text" name="attendance" /><br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
