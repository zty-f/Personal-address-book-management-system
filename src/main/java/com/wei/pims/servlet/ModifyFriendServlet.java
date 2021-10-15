package com.wei.pims.servlet;

import com.wei.pims.bean.Friend;
import com.wei.pims.manager.FriendManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifyFriendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        FriendManager manager = new FriendManager();
        Friend friend = manager.findFriendByName(userName,name);
        req.setAttribute("friend",friend);
        RequestDispatcher dispatcher = req.getRequestDispatcher("friendManager/modifyFriend2.jsp");
        dispatcher.forward(req,resp);

    }
}
