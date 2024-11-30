package org.example.workingwithgithub.servlets;


import org.example.workingwithgithub.entiry.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet("/confirm")
public class ConfirmationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = Integer.parseInt(req.getParameter("userId"));
//        User user = (User) session.getAttribute("user");
        Optional<User> optionalUser = DB.USERS.stream().filter(user1 -> user1.getId().equals(userId)).findFirst();
        if (optionalUser.isPresent()) {
            List<BasketProduct> basketProducts = DB.BASKET_PRODUCTS.stream()
                    .filter(p -> p.getUserId().equals(userId))
                    .toList();
            Order order= new Order("CREATED",LocalDateTime.now(), userId);
            for (BasketProduct basketProduct : basketProducts) {
                OrderItem orderItem=new OrderItem(order.getId(),basketProduct.getProductId()
                        ,basketProduct.getAmount());
                DB.ORDER_ITEMS.add(orderItem);
            }
            DB.ORDERS.add(order);
            DB.BASKET_PRODUCTS.removeAll(basketProducts);
            resp.sendRedirect("/order.jsp?userId="+userId);
        }else {
            resp.sendRedirect("/login.jsp?userId="+userId);
        }
    }
}
