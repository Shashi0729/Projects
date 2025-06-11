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
		<h2 class="text-center mb-4">Industry Sign Up</h2>
		<form action="IndustrySignup" method="post">
			<div
				class="container d-flex justify-content-center align-items-center"
				style="min-height: 90vh; margin-left: 110px">
				<div style="width: 100%; max-width: 700px;">
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="userName" class="form-label">Username</label> <input
								type="text" class="form-control" id="userName" name="userName"
								required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email" name="email"
								required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="contactNo" class="form-label">Contact Number</label>
							<input type="tel" class="form-control" id="contactNo"
								name="contactNo" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="GSTnumber" class="form-label">GST Number</label> <input
								type="text" class="form-control" id="GSTnumber" name="GSTnumber"
								required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="typeOfIndustry" class="form-label">Type of
								Industry</label> <input type="text" class="form-control"
								id="typeOfIndustry" name="typeOfIndustry" required>
						</div>
						<div class="col-md-4 mb-3">
							<label class="form-label">Online Service Available</label> <select
								class="form-control" id="isOnlineServiceAvaliable"
								name="isOnlineServiceAvaliable">
								<option value="true">Yes</option>
								<option value="false">No</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="city" class="form-label">City</label> <input
								type="text" class="form-control" id="city" name="city" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="state" class="form-label">State</label> <input
								type="text" class="form-control" id="State" name="state"
								required>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-3">
							<label for="country" class="form-label">Country</label> <input
								type="text" class="form-control" id="Country" name="country"
								required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="country" class="form-label">PinCode</label> <input
								type="text" class="form-control" id="pincode" name="pincode"
								required>
						</div>
					</div>
					<div class="row">

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
				<button type="reset" class="btn btn-danger">Reset</button>
			</div>
		</form>
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

		updateDateTime();
		setInterval(updateDateTime, 1000);
	</script>
</body>
</html>
