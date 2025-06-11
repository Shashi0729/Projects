<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<div class="dropdown me-2">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">Users</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="Activeusers">Active
								Users</a></li>
						<li><a class="dropdown-item" href="InActiveusers">Inactive
								Users</a></li>
					</ul>
				</div>

				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						Companies</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="ApprovedIndustry">Approved</a></li>
						<li><a class="dropdown-item" href="NotApprovedIndustry">Pending</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<!-- Full-Width Table -->
	<div class="container-fluid mt-4">
		<div class="table-responsive">
			<table
				class="table table-striped table-hover table-bordered text-center w-100">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>User Name</th>
						<th>User Email</th>
						<th>Adhar Number</th>
						<th>Contact Number</th>
						<th>ALT Contact Number</th>
						<th>DOB</th>
						<th>Country</th>
						<th>State</th>
						<th>City</th>
						<th>Pin Code</th>
						<th>Address</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="save" items="${viewActive}">
						<tr>
							<td>${save.id}</td>
							<td>${save.userName}</td>
							<td>${save.email}</td>
							<td>${save.adharNumber}</td>
							<td>${save.contactNo}</td>
							<td>${save.alternativeContactNo}</td>
							<td>${save.dateOfBirth}</td>
							<td>${save.country}</td>
							<td>${save.state}</td>
							<td>${save.city}</td>
							<td>${save.pincode}</td>
							<td>${save.address}</td>
							<td><a href="Adminupdate?email=${save.email}"
								class="btn btn-sm btn-primary">Update</a> <a
								href="Admindelete?email=${save.email}"
								class="btn btn-sm btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
					<c:forEach var="save" items="${viewInActive}">
						<tr>
							<td>${save.id}</td>
							<td>${save.userName}</td>
							<td>${save.email}</td>
							<td>${save.adharNumber}</td>
							<td>${save.contactNo}</td>
							<td>${save.alternativeContactNo}</td>
							<td>${save.dateOfBirth}</td>
							<td>${save.country}</td>
							<td>${save.state}</td>
							<td>${save.city}</td>
							<td>${save.pincode}</td>
							<td>${save.address}</td>
							<td><a href="Adminupdateinactive?email=${save.email}"
								class="btn btn-sm btn-warning">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="container-fluid mt-4">
		<div class="table-responsive">
			<table
				class="table table-striped table-hover table-bordered text-center w-100">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Company Name</th>
						<th>Company Email</th>
						<th>GST Number</th>
						<th>Contact Number</th>
						<th>Type Of Industry</th>
						<th>Country</th>
						<th>State</th>
						<th>City</th>
						<th>Pin Code</th>
						<th>Address</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="save" items="${viewApproved}">
						<tr>
							<td>${save.id}</td>
							<td>${save.userName}</td>
							<td>${save.email}</td>
							<td>${save.GSTnumber}</td>
							<td>${save.contactNo}</td>
							<td>${save.typeOfIndustry}</td>
							<td>${save.country}</td>
							<td>${save.state}</td>
							<td>${save.city}</td>
							<td>${save.pincode}</td>
							<td>${save.address}</td>
							<td><a href="AdminIndustryupdate?email=${save.email}"
								class="btn btn-sm btn-primary">Update</a> <a
								href="AdminIndustrydelete?email=${save.email}"
								class="btn btn-sm btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
					<c:forEach var="save" items="${viewNotApproved}">
						<tr>
							<td>${save.id}</td>
							<td>${save.userName}</td>
							<td>${save.email}</td>
							<td>${save.GSTnumber}</td>
							<td>${save.contactNo}</td>
							<td>${save.typeOfIndustry}</td>
							<td>${save.country}</td>
							<td>${save.state}</td>
							<td>${save.city}</td>
							<td>${save.pincode}</td>
							<td>${save.address}</td>
							<td><a href="Approve?email=${save.email}"
								class="btn btn-sm btn-primary">Approve</a> <a
								href="Reject?email=${save.email}"
								class="btn btn-sm btn-warning">Reject</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

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
