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

public class UpdatePasswordMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String password = req.getParameter("password");

        if (TextUtils.isEmpty(password)) {
            String mainUrl = resp.encodeRedirectURL("LookMessageServlet");
            resp.sendRedirect(mainUrl);
        } else {
            UserManager userManager = new UserManager();
            HttpSession session = req.getSession();
            String userName = (String) session.getAttribute("userName");
            User user = userManager.findUserByUserName(userName);
            user.setPassword(password);
            userManager.modify(user);
            String mainUrl = resp.encodeRedirectURL("LookMessageServlet");
            resp.sendRedirect(mainUrl);
        }
    }
}
