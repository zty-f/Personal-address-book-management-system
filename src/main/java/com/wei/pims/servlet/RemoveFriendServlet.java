package com.wei.pims.servlet;

import com.wei.pims.manager.FriendManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveFriendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String name = req.getParameter("name");
        FriendManager manager = new FriendManager();
        manager.remove(userName, name);
        resp.sendRedirect("LookFriend");
    }
}
