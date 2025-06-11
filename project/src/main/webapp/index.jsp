<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP Page with Custom Colors</title>
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

footer {
	background-color: var(--footer-bg);
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container">
				<img alt="Logo" src="images/logo.JPG">
				<div class="ms-auto">
					<div class="btn-group me-2">
						<button class="btn btn-custom-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
							Sign Up
						</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="signup">User Signup</a></li>
							<li><a class="dropdown-item" href="IndustryRegister">Industry Signup</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button class="btn btn-custom-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
							Sign In
						</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="signin">User Sign In</a></li>
							<li><a class="dropdown-item" href="admintosignin">Admin Sign In</a></li>
							<li><a class="dropdown-item" href="IndustrySignin">Industry Sign In</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<main class="container my-5">
		<h1 class="mb-4">Welcome Page</h1>
		<p></p>
		<form action="Upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" placeholder="enterfile">
		<input type="submit" value="upload">
		</form>
	</main>

	<footer class="text-light py-3 mt-auto">
		<div class="container text-center">
			<p class="mb-1">&copy; 2023 SG Group. All rights reserved.</p>
			<p id="datetime" class="mb-0"></p>
		</div>
	</footer>

	<!-- Bootstrap JS and Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		function updateDateTime() {
			var now = new Date();
			var dateTimeString = now.toLocaleString();
			document.getElementById('datetime').textContent = "Current Date and Time: " + dateTimeString;
		}

		updateDateTime();
		setInterval(updateDateTime, 1000);
	</script>
</body>
</html>
