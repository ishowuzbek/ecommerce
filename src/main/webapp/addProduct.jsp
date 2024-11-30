<%@ page import="org.example.workingwithgithub.entiry.Category" %>
<%@ page import="org.example.workingwithgithub.entiry.DB" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/21/2024
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Product</title>
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
      max-width: 600px;
      margin: 50px auto;
    }
    h1 {
      color: #343a40;
    }
    .form-label {
      font-weight: bold;
      color: #495057;
    }
    .btn-primary {
      background-color: #007bff;
      border: none;
      transition: background-color 0.3s;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Add Product</h1>
  <form action="/product/add" method="post" enctype="multipart/form-data">
    <div class="mb-3">
      <label for="productImage" class="form-label">Product Image</label>
      <input type="file" class="form-control" id="productImage" name="productImage">
    </div>
    <div class="mb-3">
      <label for="productName" class="form-label">Product Name</label>
      <input type="text" class="form-control" id="productName" name="name" placeholder="Enter product name" required>
    </div>
    <div class="mb-3">
      <label for="productPrice" class="form-label">Product Price</label>
      <input type="number" class="form-control" id="productPrice" name="price" placeholder="Enter product price" required>
    </div>
    <div class="mb-3">
      <label for="productCatID" class="form-label">Product Category</label>
      <select class="form-select" id="productCatID" name="categoryId" required>
        <option value="" disabled selected>Select a category</option>
        <%
          for (Category category : DB.CATEGORIES) {
        %>
        <option value="<%=category.getId()%>"><%=category.getName()%></option>
        <%
          }
        %>
      </select>
    </div>
    <button type="submit" class="btn btn-primary w-100">Save</button>
  </form>
</div>
</body>
</html>
