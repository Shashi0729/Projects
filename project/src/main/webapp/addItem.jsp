<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Item - Your Company Name</title>
<!-- Bootstrap CSS -->
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet">
<style>
:root {
    --header-bg: #3498db;
    --footer-bg: #3498db;
    --button-primary: #e74c3c;
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
                <a class="navbar-brand" href="#">LOGO</a>
            </div>
        </nav>
    </header>

    <main class="container mt-5">
        <h2 class="text-center">Add New Item</h2>
      

        <!-- Item Details Form -->
        <form action="uploadItemDetails" method="post" enctype="multipart/form-data" class="mt-4">
        <input type="text" name=email value="${companyEmail}">
        <div class="mb-3">  
                <label for="itemImage" class="form-label">Upload Image</label>
            <input type="file" class="form-control" id="itemImage" name="itemImage" accept=".jpg" required>
            </div>
            <div class="mb-3">
                <label for="itemNumber" class="form-label">Item Number</label>
                <input type="number" class="form-control" id="itemNo" name="itemNo" step="0.01" required>
            </div>
            <div class="mb-3">
                <label for="itemName" class="form-label">Item Name</label>
                <input type="text" class="form-control" id="itemName" name="itemName" required>
            </div>
            <div class="mb-3">
                <label for="itemDescription" class="form-label">Description</label>
                <textarea class="form-control" id="discription" name="discription"  required></textarea>
            </div>
            <div class="mb-3">
                <label for="itemPrice" class="form-label">Price</label>
                <input type="number" class="form-control" id="price" name="price" step="0.01" required>
            </div>
            <button type="submit" class="btn btn-custom-primary">Save Item Details</button>
        </form>

        <!-- File Upload Form -->
        
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
            document.getElementById('datetime').textContent = "Current Date and Time: " + dateTimeString;
        }
        
        updateDateTime();
        setInterval(updateDateTime, 1000);
    </script>
</body>
</html>
