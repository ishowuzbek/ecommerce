<%@ page import="java.util.Optional" %>
<%@ page import="org.example.workingwithgithub.entiry.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Marketplace HomePage</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    final Integer userId;
    if (user != null) {
        userId = user.getId();
    } else {
        userId = null;
    }
%>

<div class="container-fluid">
    <div class="row">
        <header class="d-flex justify-content-between align-items-center py-3 px-4 bg-light border-bottom">
            <h1 class="h3">Marketplace</h1>
            <div class="d-flex gap-2">
                <%
                    long sum = DB.BASKET_PRODUCTS.stream()
                            .filter(p -> p.getUserId().equals(userId))
                            .count();
                %>
                <a href="order.jsp?userId=<%=userId%>" class="btn btn-dark">My orders</a>
                <%
                    if (userId != null && userId > 1000) {
                %>
                <a href="/login?userId=<%=userId%>" class="btn btn-dark">Login</a>
                <%
                    }
                %>
                <%
                    if (userId != null && userId < 1000) {
                %>
                <a href="/logout" class="btn btn-dark">Logout</a>
                <%
                    }
                %>

                <%
                    if(sum>0){
                        %>
                <a href="basket.jsp?userId=<%=userId%>" class="btn btn-dark">
                    Basket <%=sum%>
                </a>
                <%
                    }
                %>

            </div>
        </header>
    </div>
    <div class="row">
        <nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
            <div class="position-sticky">
                <h5 class="pt-3 ps-3">Categories</h5>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="homepage.jsp">All</a>
                    </li>
                    <%
                        for (Category category : DB.CATEGORIES) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="homepage.jsp?category=<%=category.getName()%>"><%=category.getName()%>
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Products</h2>
            </div>
            <div class="row">
                <%
                    String selectedCategory = request.getParameter("category");

                    for (Product product : DB.PRODUCTS) {
                        boolean matchesCategory = (selectedCategory == null ||
                                selectedCategory.equals("All") ||
                                product.getCategoryName().equals(selectedCategory));
                        if (matchesCategory) {
                %>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="/file/<%=product.getId()%>" class="card-img-top" alt="<%=product.getName()%>"
                             style="height: 150px; object-fit: cover;">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%>
                            </h5>
                            <p class="card-text"><%=product.getPrice()%> sum</p>
                            <form action="/un-select" method="post">
                                <input type="hidden" name="product" value="<%=product.getId()%>">
                                <%
                                    System.out.println(DB.BASKET_PRODUCTS);
                                    Optional<BasketProduct> basketProductOptional = DB.BASKET_PRODUCTS.stream()
                                            .filter(p -> p.getProductId().equals(product.getId()) &&
                                                    p.getUserId().equals(userId))
                                            .findFirst();
                                    if (basketProductOptional.isPresent()) {
                                %>
                                <input type="hidden" name="action" value="unselect">
                                <button type="submit" class="btn btn-danger btn-sm">Unselect</button>
                                <%
                                } else {
                                %>
                                <input type="hidden" name="action" value="select">
                                <button type="submit" class="btn btn-dark btn-sm">Select</button>
                                <%
                                    }
                                %>
                            </form>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </main>
    </div>
</div>
</body>
</html>
