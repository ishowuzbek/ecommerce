<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/26/2024
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Category</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .container {
      background-color: #ffffff;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      padding: 30px;
      max-width: 500px;
      margin: 50px auto;
    }
    h1 {
      color: #343a40;
      font-size: 2rem;
      text-align: center;
      margin-bottom: 20px;
    }
    .form-label {
      font-weight: bold;
      color: #495057;
    }
    .btn-primary {
      background-color: #007bff;
      border: none;
      transition: background-color 0.3s ease;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h1>Add Category</h1>
  <form action="/add/category" method="post">
    <div class="mb-3">
      <label for="categoryName" class="form-label">Category Name</label>
      <input type="text" class="form-control" id="categoryName" name="name" placeholder="Enter category name" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Save</button>
  </form>
</div>
</body>
</html>
