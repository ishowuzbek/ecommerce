package org.example.workingwithgithub.servlets;


import org.example.workingwithgithub.entiry.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Random rand = new Random();
        if (session.getAttribute("user") == null) {
            int randNum = rand.nextInt(9000) + 1000;
            session.setAttribute("user", new User(randNum));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("homepage.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
