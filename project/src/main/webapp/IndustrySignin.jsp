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
				<a class="navbar-brand" href="#">Your Logo</a>
				<div class="ms-auto">
					<a href="signup.jsp" class="btn btn-custom-secondary">Sign Up</a>
				</div>
			</div>
		</nav>
	</header>

	<main class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center mb-4">Industry SignIn</h2>
				<form action="IndustrysOTPverification" method="post">
					<div class="col-md-6 mb-3" style="margin-left: 130px;">
						<label for="email" class="form-label">Email address</label> <input
							type="email" class="form-control" id="email" name="email"
							onchange="checkEmail()" required> <span id="response"></span>
					</div>

					<!-- OTP Field (Initially Disabled) -->
					<div class="col-md-6 mb-3" style="margin-left: 130px;">
						<label for="otp" class="form-label">Enter OTP</label> <input
							type="text" class="form-control" id="otp" name="otp" disabled
							oninput="enableVerifyOTP()">
					</div>

					<div class="d-grid gap-2 col-2 mx-auto">

						<button type="button" class="btn btn-custom-primary" id="sendOTP"
							onclick="handleSendOTP()" disabled>Send OTP</button>


					</div>

					<br>
					<!-- Verify OTP Button (Initially Disabled) -->
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="submit" class="btn btn-custom-secondary"
							id="verifyOTP" disabled>Verify OTP</button>
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
			var sendOTPButton = document.getElementById("sendOTP"); // Get Send OTP button

			const req = new XMLHttpRequest();
			req.open("GET",
					"http://localhost:8080/project/IndustrySignInGetEmail?email="
							+ useremail);
			req.send();
			req.onload = function() {
				let response = req.responseText.trim(); // Trim any whitespace

				document.getElementById("response").innerHTML = response;

				if (response === "Email approved!") {
					sendOTPButton.disabled = false; // Enable the Send OTP button
				} else {
					sendOTPButton.disabled = true; // Keep it disabled
				}
			}
		}

		function enableOTP() {
			document.getElementById("otp").disabled = false;
		}

		function enableVerifyOTP() {
			var otpField = document.getElementById("otp").value;
			var verifyButton = document.getElementById("verifyOTP");

			if (otpField.length > 0) {
				verifyButton.disabled = false;
			} else {
				verifyButton.disabled = true;
			}
		}

		function handleSendOTP() {
			var useremail = document.getElementById("email").value;

			if (!useremail) {
				alert("Please enter a valid email address.");
				return;
			}

			const req = new XMLHttpRequest();
			req.open("GET", "http://localhost:8080/project/IndustrysendOTP?email="
					+ useremail, true);
			req.send();

			req.onload = function() {
				let response = req.responseText.trim();

				if (response === "OTP Sent Successfully") {
					
					document.getElementById("otp").disabled = false; // Enable OTP input field
				} else {
					alert("Failed to send OTP. Please try again.");
				}
			};
		}
	</script>
</body>
</html>
