package org.example.workingwithgithub.servlets;

import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.entiry.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet("/product/add")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    String absolutePath = "D:/javanew/WorkingWithGitHub/files/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("productImage");
        byte[] bytes = part.getInputStream().readAllBytes();
        Path path = Files.write(Path.of(absolutePath + UUID.randomUUID() + ".jpg"),bytes);
        String name = req.getParameter("name");
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Integer price = Integer.parseInt(req.getParameter("price"));
        String photoUrl = path.toString();
        System.out.println(photoUrl);
        Product product = new Product(
                name,
                price,
                categoryId,
                photoUrl
        );
        DB.PRODUCTS.add(product);

        resp.sendRedirect("/");
    }
}

