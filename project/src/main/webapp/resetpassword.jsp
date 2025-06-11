<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reset Password - Your Company Name</title>
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
				<a class="navbar-brand" href="#">Your Logo</a>
			</div>
		</nav>
	</header>

	<main class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center mb-4">Reset Password</h2>
				<form action="ResetPassword" method="post">
				<input type="hidden" class="form-control" id="email" name="email" value="${email}">
				
					<div class="mb-3">
						<label for="newPassword" class="form-label">New Password</label>
						<input type="password" class="form-control" id="newPassword" name="password" required oninput="checkPasswordMatch()">
					</div>
					<div class="mb-3">
						<label for="confirmPassword" class="form-label">Confirm Password</label>
						<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required oninput="checkPasswordMatch()">
						<span id="passwordMatchMessage" class="text-danger"></span>
					</div>
					<div class="d-grid gap-2 col-4 mx-auto">
						<button type="submit" class="btn btn-custom-primary" id="resetButton" disabled>Reset Password</button>
					</div>
				</form>
			</div>
		</div>
	</main>

	<footer class="text-light py-3 mt-auto">
		<div class="container text-center">
			<p class="mb-1">&copy; 2023 SG Group. All rights reserved.</p>
			<p id="datetime" class="mb-0"></p>
		</div>
	</footer>

	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		function checkPasswordMatch() {
			var newPassword = document.getElementById("newPassword").value;
			var confirmPassword = document.getElementById("confirmPassword").value;
			var resetButton = document.getElementById("resetButton");
			var message = document.getElementById("passwordMatchMessage");

			if (newPassword === confirmPassword && newPassword.length > 0) {
				resetButton.disabled = false;
				message.textContent = "";
			} else {
				resetButton.disabled = true;
				message.textContent = "Passwords do not match.";
			}
		}
	</script>
</body>
</html>
