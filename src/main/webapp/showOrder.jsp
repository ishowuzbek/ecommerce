
<%@ page import="java.util.List" %>
<%@ page import="org.example.workingwithgithub.entiry.OrderItem" %>
<%@ page import="org.example.workingwithgithub.entiry.DB" %>
<%@ page import="org.example.workingwithgithub.entiry.Product" %>
<%@ page import="org.example.workingwithgithub.services.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/26/2024
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Show Order</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .table {
      background-color: white;
    }
    h1 {
      font-size: 2.5rem;
      color: #343a40;
      margin-bottom: 20px;
    }
    .text-end {
      font-weight: bold;
      font-size: 1.2rem;
    }
    .back-btn {
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center">Order Information</h1>
  <div class="table-responsive">
    <table class="table table-bordered mt-4">
      <thead class="table-dark">
      <tr>
        <th>№</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Subtotal</th>
      </tr>
      </thead>
      <tbody>
      <%
//        Integer userId = Integer.parseInt(request.getParameter("userId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int i = 1;
        int total = 0;
        List<OrderItem> list = DB.ORDER_ITEMS.stream().filter(orderItem -> orderItem.getOrderId().equals(orderId)).toList();
        for (OrderItem orderItem : list) {
          Product product = ProductService.getProductById(orderItem.getProductId());
          int productTotal = product.getPrice() * orderItem.getAmount();
          total += productTotal;
      %>
      <tr>
        <td><%= i++ %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %> sum</td>
        <td><%= orderItem.getAmount() %></td>
        <td><%= productTotal %> sum</td>
      </tr>
      <%
        }
      %>
      </tbody>
      <tfoot>
      <tr class="table-secondary">
        <td colspan="4" class="text-end"><strong>Total:</strong></td>
        <td><strong><%= total %> sum</strong></td>
      </tr>
      </tfoot>
    </table>
  </div>
  <div class="text-center back-btn">
    <a href="/" class="btn btn-secondary">Back</a>
  </div>
</div>

</body>
</html>
