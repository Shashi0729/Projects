<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up - Your Company Name</title>
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
				<img alt="Logo" src="images/logo.svg">
				<div class="ms-auto">
					<button class="btn btn-custom-primary"
						onclick="window.location.href='signin.jsp'">Sign In</button>
				</div>
			</div>
		</nav>
	</header>

	<main class="container">
		<h2 class="text-center mb-4">Sign Up</h2>
		<form action="SignupSubmit" method="post"> 
			<div
				class="container d-flex justify-content-center align-items-center"
				style="min-height: 90vh; margin-left: 110px">
				<div style="width: 100%; max-width: 700px;">
					<!-- Limit the form width -->
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="userName" class="form-label">Username</label> <input
								type="text" align="center" class="form-control" id="userName"
								name="userName" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email" name="email"
								onchange="checkEmail()" required> <span id="response"></span>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" class="form-control" id="password"
								name="password" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="contactNo" class="form-label">Contact Number</label>
							<input type="tel" class="form-control" id="contactNo"
								name="contactNo" onchange="checkContact()" required> <span
								id="contactResponse"></span>

						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="adharNumber" class="form-label">Adhar Number</label>
							<input type="text" class="form-control" id="adharNumber"
								name="adharNumber" onchange="checkAdhar()" required> <span
								id="adharResponse"></span>
						</div>
						<div class="col-md-4 mb-3">
							<label for="alternativeContactNo" class="form-label">Alternative
								Contact Number</label> <input type="tel" class="form-control"
								id="alternativeContactNo" name="alternativeContactNo">
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="dateOfBirth" class="form-label">Date of Birth</label>
							<input type="date" class="form-control" id="dateOfBirth"
								name="dateOfBirth" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="country" class="form-label">Country</label> <input
								type="text" class="form-control" id="country" name="country"
								required>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="state" class="form-label">State</label> <input
								type="text" class="form-control" id="state" name="state"
								required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="city" class="form-label">City</label> <input
								type="text" class="form-control" id="city" name="city" required>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="pincode" class="form-label">Pincode</label> <input
								type="text" class="form-control" id="pincode" name="pincode"
								required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="address" class="form-label">Address</label> <input
								type="text" class="form-control" id="address" name="address"
								required>
						</div>
					</div>
				</div>
			</div>


			<div class="d-flex gap-2 col-2 mx-auto">
				<button type="submit" class="btn btn-success">Sign Up</button>
				<button type="reset" class="btn btn-danger ">Reset</button>

			</div><br>
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
			document.getElementById('datetime').textContent = "Current Date and Time: "
					+ dateTimeString;
		}

		// Update the date and time immediately and then every second
		updateDateTime();
		setInterval(updateDateTime, 1000);

		function checkEmail() {

			var useremail = document.getElementById("email").value;
			const req = new XMLHttpRequest;
			req.open("GET", "http://localhost:8080/project/GetEmail?email="
					+ useremail);
			req.send();
			req.onload = function() {
				let response = req.responseText;
				document.getElementById("response").innerHTML = response;
			}
		}

		function checkAdhar() {

			let adhar = document.getElementById("adharNumber").value;
			const req = new XMLHttpRequest;
			req.open("GET",
					"http://localhost:8080/project/GetAdhar?adharNumber="
							+ adhar);
			req.send();
			req.onload = function() {
				let response = req.responseText;
				document.getElementById("adharResponse").innerHTML = response;
			}
		}

		function checkContact() {

			let contact = document.getElementById("contactNo").value;
			const req = new XMLHttpRequest;
			req.open("GET",
					"http://localhost:8080/project/GetContact?contactNumber="
							+ contact);
			req.send();
			req.onload = function() {
				let response = req.responseText;
				document.getElementById("contactResponse").innerHTML = response;
			}
		}
	</script>
</body>
</html>