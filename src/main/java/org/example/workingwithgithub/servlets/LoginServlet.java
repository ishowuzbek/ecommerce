package org.example.workingwithgithub.servlets;


import org.example.workingwithgithub.entiry.BasketProduct;
import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.entiry.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp?userId="+userId);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int userId = Integer.parseInt(req.getParameter("userId"));
        Optional<User> user = DB.USERS.stream().filter(u -> u.getName().equals(name) && u.getPassword().equals(password)).findFirst();
        if (user.isPresent()) {
            User userDB = user.get();
            if (userDB.getRole().equals("admin")) {
                req.getSession().setAttribute("user", userDB);
                resp.sendRedirect("/admin");
            }else {
                for (BasketProduct basketProduct : DB.BASKET_PRODUCTS.stream().filter(basketProduct -> basketProduct.getUserId().equals(userId)).toList()) {
                    DB.BASKET_PRODUCTS.add(new BasketProduct(
                            basketProduct.getProductId(),
                            userDB.getId(),
                            basketProduct.getAmount(),
                            basketProduct.getPrice()
                    ));
                }
                req.getSession().invalidate();
                req.getSession().setAttribute("user", userDB);
                if (!DB.ORDER_ITEMS.isEmpty()){
                    resp.sendRedirect("/basket.jsp");
                }else {
                    resp.sendRedirect("/");
                }
            }
        }else {
            System.out.println("pp");
            resp.sendRedirect("signup.jsp?userId="+userId);
        }
    }
}
