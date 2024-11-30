package org.example.workingwithgithub.servlets;



import org.example.workingwithgithub.entiry.Category;
import org.example.workingwithgithub.entiry.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add/category")
public class addCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        DB.CATEGORIES.add(new Category(name));
        resp.sendRedirect("/admin.jsp");
    }
}
