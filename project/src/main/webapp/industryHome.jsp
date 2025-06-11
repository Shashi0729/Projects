<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign In - Your Company Name</title>
<!-- Bootstrap CSS -->
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet">
<style>
:root {
    --header-bg: #3498db;
    --footer-bg: #3498db;
    --button-primary: #e74c3c;
    --button-secondary: #f39c12;
}

body {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    background-color: #ecf0f1;
}

main {
    flex: 1;
}

.navbar {
    background-color: var(--header-bg) !important;
}

.navbar-brand, .navbar-nav .nav-link {
    color: white !important;
}

.btn-custom-primary {
    background-color: var(--button-primary);
    border-color: var(--button-primary);
    color: white;
}

.btn-custom-primary:hover {
    background-color: #c0392b;
    border-color: #c0392b;
    color: white;
}

.btn-custom-secondary {
    background-color: var(--button-secondary);
    border-color: var(--button-secondary);
    color: white;
}

.btn-custom-secondary:hover {
    background-color: #d35400;
    border-color: #d35400;
    color: white;
}

footer {
    background-color: var(--footer-bg);
}
</style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container">
                <a class="navbar-brand" href="#">LOGO</a>
                <div>${email}</div>
                <div class="dropdown">
                    <a class="btn btn-secondary dropdown-toggle" href="#"
                        role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
                        aria-expanded="false"> Profile </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <li><a class="dropdown-item" href="industryupdate?email=${email}">Edit</a></li>
                        <li><a class="dropdown-item" href="industrydelete?email=${email}">Delete</a></li>
                        <li><a class="dropdown-item" href="IndustrySignin.jsp">SignOut</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <main class="container text-center mt-5">
        <h2>Welcome to Your Dashboard</h2>
        <p>Manage your items efficiently.</p>
        <a href="addItems?email=${email}" class="btn btn-custom-primary">Add Items</a>
    </main>

    <footer class="text-light py-3 mt-auto">
        <div class="container text-center">
            <p class="mb-1">&copy; 2023 SG Group. All rights reserved.</p>
            <p id="datetime" class="mb-0"></p>
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function updateDateTime() {
            var now = new Date();
            var dateTimeString = now.toLocaleString();
            document.getElementById('datetime').textContent = "Current Date and Time: "
                    + dateTimeString;
        }

        // Update the date and time immediately and then every second
        updateDateTime();
        setInterval(updateDateTime, 1000);
    </script>
</body>
</html>
