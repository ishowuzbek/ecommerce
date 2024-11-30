package org.example.workingwithgithub.servlets;


import org.example.workingwithgithub.entiry.DB;
import org.example.workingwithgithub.entiry.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class signUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp?userId="+userId);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int userId = Integer.parseInt(req.getParameter("userId"));
        DB.USERS.add(new User(name, password));
        resp.sendRedirect("/login?userId="+userId);
    }
}
