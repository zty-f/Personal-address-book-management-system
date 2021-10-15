package com.wei.pims.servlet;

import com.wei.pims.bean.User;
import com.wei.pims.manager.UserManager;
import com.wei.pims.util.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            resp.sendRedirect("login.jsp");
            return;
        }

        UserManager userManager = new UserManager();
        if (userManager.login(username, password)) {
            HttpSession session = req.getSession();
            User user = userManager.findUserByUserName(username);
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getUserName());
            resp.sendRedirect("/main/main.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }

    }
}
