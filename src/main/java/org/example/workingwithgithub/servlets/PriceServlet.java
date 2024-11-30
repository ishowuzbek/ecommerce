package org.example.workingwithgithub.servlets;




import org.example.workingwithgithub.entiry.BasketProduct;
import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.services.BasketProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/price")
public class PriceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String basketProductId = req.getParameter("productId");
        if (basketProductId != null) {
            Integer productId = Integer.parseInt(basketProductId);
            String action = req.getParameter("action");
            BasketProduct basketProduct =
                    DB.BASKET_PRODUCTS.stream()
                            .filter(item -> item.getId().equals(productId)).findFirst().get();
            if (action.equals("plus")) {
                basketProduct.setAmount(basketProduct.getAmount() + 1);
            } else {
                if (basketProduct.getAmount() >= 2) {
                    basketProduct.setAmount(basketProduct.getAmount() - 1);
                } else {
                    if (basketProduct.getAmount() == 1) {
                        BasketProductService.deleteById(basketProduct.getId());
                    }
                }
            }
            resp.sendRedirect("basket.jsp");
        }
    }
}
