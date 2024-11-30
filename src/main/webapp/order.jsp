
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.workingwithgithub.entiry.DB" %>
<%@ page import="org.example.workingwithgithub.entiry.Order" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/25/2024
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Orders</title>
</head>
<body>
<div class="container my-5">
  <h2 class="mb-4">My Orders</h2>
  <table class="table table-bordered table-hover">
    <thead class="table-dark">
    <tr>
      <th>№</th>
      <th>Order Time</th>
      <th>Status</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
      int userId = Integer.parseInt(request.getParameter("userId"));
      List<Order> optionalOrder = DB.ORDERS.stream().filter(order -> order.getUserId().equals(userId)).toList();
      int i=1;
      for (Order order : optionalOrder) {
        %>
    <tr>
      <td><%=i++%></td>
      <td><%=order.getOrderDate()%></td>
      <td><%=order.getStatus()%></td>
      <td>
        <form action="showOrder.jsp">
<%--          <input type="hidden" name="userId" value="<%=userId%>">--%>
          <input type="hidden" name="orderId" value="<%=order.getId()%>">
          <button class="btn btn-primary btn-sm">Show</button>
        </form>
      </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <a href="/" class="btn btn-secondary">Back Home</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
