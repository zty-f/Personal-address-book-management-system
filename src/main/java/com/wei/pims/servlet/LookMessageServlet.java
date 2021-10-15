package com.wei.pims.servlet;

import com.wei.pims.bean.User;
import com.wei.pims.manager.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LookMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");
        UserManager userManager = new UserManager();
        User user = new User();
        user.setId(userId);
        user = userManager.query(user);
        req.setAttribute("user",user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("infoManager/lookMessage.jsp");
        dispatcher.forward(req,resp);
    }
}
