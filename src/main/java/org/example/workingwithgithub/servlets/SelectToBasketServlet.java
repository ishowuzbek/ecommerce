package org.example.workingwithgithub.servlets;


import org.example.workingwithgithub.entiry.BasketProduct;
import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.entiry.Product;
import org.example.workingwithgithub.entiry.User;
import org.example.workingwithgithub.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/un-select")
public class SelectToBasketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("product"));
        String action = req.getParameter("action");

        Product productById = ProductService.getProductById(productId);
        if (productById == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Integer userId = user.getId();
        if ("select".equals(action)) {
            BasketProduct basketProduct = new BasketProduct(
                    productId,
                    userId,
                    1,
                    productById.getPrice()
            );
            DB.BASKET_PRODUCTS.add(basketProduct);
        } else if ("unselect".equals(action)) {
            Optional<BasketProduct> basketProduct = DB.BASKET_PRODUCTS.stream()
                    .filter(p -> p.getProductId().equals(productId) && p.getUserId().equals(userId))
                    .findFirst();
            basketProduct.ifPresent(DB.BASKET_PRODUCTS::remove);
        }
        resp.sendRedirect("/");
    }
}
