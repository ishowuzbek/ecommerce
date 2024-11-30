<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/21/2024
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Admin</title>
</head>
<body>
<div class="container-fluid">
  <div class="row vh-100">
    <div class="col-3 bg-dark text-white p-4">
      <h4>Admin Panel</h4>
      <ul class="nav flex-column mt-4">
        <li class="nav-item">
          <a class="nav-link text-white" href="addProduct.jsp">Add Product</a>
          <a class="nav-link text-white" href="addCategory.jsp"> Add Category</a>
        </li>
      </ul>
    </div>

    <div class="col bg-light p-5">
      <h1 class="text-center">Welcome to Admin Page</h1>
    </div>
  </div>
</div>
</body>
</html>
