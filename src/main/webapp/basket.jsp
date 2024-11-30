<%@ page import="java.util.*" %>
<%@ page import="org.example.workingwithgithub.entiry.User" %>
<%@ page import="org.example.workingwithgithub.entiry.BasketProduct" %>
<%@ page import="org.example.workingwithgithub.entiry.DB" %>
<%@ page import="org.example.workingwithgithub.entiry.Product" %>
<%@ page import="org.example.workingwithgithub.services.ProductService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Basket</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.jsp");
        return;
    }
    Integer userId = user.getId();
%>
<div class="container mt-3">
    <h2 class="mb-3">Basket</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            Integer totalAmount = 0;
            List<BasketProduct> basketProducts = DB.BASKET_PRODUCTS.stream()
                    .filter(p -> p.getUserId().equals(userId))
                    .toList();
            for (BasketProduct basketProduct : basketProducts) {
                Product product = ProductService.getProductById(basketProduct.getProductId());
                if (product == null) continue;
                int productTotal = basketProduct.getAmount() * product.getPrice();
                totalAmount += productTotal;
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= basketProduct.getAmount() %></td>
            <td><%= productTotal %> sum</td>
            <td>
                <form action="/price" method="post">
                    <input type="hidden" name="productId" value="<%= basketProduct.getProductId() %>">
                    <button type="submit" name="action" value="plus" class="btn btn-dark btn-sm">+</button>
                    <button type="submit" name="action" value="minus" class="btn btn-dark btn-sm">-</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <hr>
    <h3>Total Amount: <%= totalAmount %> sum</h3>
    <div class="d-flex justify-content-between mt-3">
        <a href="/" class="btn btn-secondary">Back to Home</a>
        <form action="/confirm" method="get">
            <input type="hidden" name="userId" value="<%=userId%>">
            <button class="btn btn-success">Confirm Purchase</button>
        </form>
    </div>
</div>
</body>
</html>
