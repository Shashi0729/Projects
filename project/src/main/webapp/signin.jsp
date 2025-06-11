<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In - Your Company Name</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
                <h2 class="text-center mb-4">Sign In</h2>
                <form action="SigninSubmit" method="post">
                    <div class="col-md-6 mb-3" style="margin-left: 130px;">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="email" name="email" onchange="checkEmail()" required>
                        <span id="response"></span>
                    </div>
                    <div class="col-md-6 mb-3" style="margin-left: 130px;">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                        <span> ${checkblock}</span>  
                        <span>${checkemailandpassword}</span>
                    </div>
                       
                    <div class="d-grid gap-2 col-2 mx-auto">  
                        <button type="submit" class="btn btn-custom-primary">Sign In</button>
                    </div>
                </form>
                <div class="text-center mt-3">
                    <a href="signup.jsp" class="text-decoration-none">New User? Register Here</a>
                    </div>
                    <div class="text-center mt-3">
                     <a href="resetpasswordOTPsending.jsp" class="text-decoration-none">Reset password</a>
                </div>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
        function updateDateTime() {
            var now = new Date();
            var dateTimeString = now.toLocaleString();
            document.getElementById('datetime').textContent = "Current Date and Time: " + dateTimeString;
        }

        // Update the date and time immediately and then every second
        updateDateTime();
        setInterval(updateDateTime, 1000);
        
    	function checkEmail() {

			var useremail = document.getElementById("email").value;
			const req = new XMLHttpRequest;
			req.open("GET", "http://localhost:8080/project/SignInGetEmail?email="+ useremail);
			req.send();
			req.onload = function() {
				let response = req.responseText;
				document.getElementById("response").innerHTML = response;
			}
		}
    </script>
</body>
</html>