<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Traffic Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Traffic Management System</h1>
    </header>
    <main>
        <!-- Traffic Information -->
        <section>
            <h2>Traffic Status</h2>
            <p>Current Status: <strong>${trafficStatus}</strong></p>
            <p>Average Speed: <strong>${averageSpeed} km/h</strong></p>
        </section>

        <!-- User Information -->
        <section>
            <h2>Registered Users</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </main>
    <footer>
        <p>&copy; 2025 Traffic Management System</p>
    </footer>
</body>
</html>
