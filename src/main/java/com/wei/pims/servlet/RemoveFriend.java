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
import java.util.ArrayList;
import java.util.List;

public class RemoveFriend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        FriendManager manager = new FriendManager();
        List<Friend> friends = manager.findAll(userName);
        List<String> names = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            names.add(friends.get(i).getName());
        }
        req.setAttribute("friendNames",names);
        RequestDispatcher dispatcher = req.getRequestDispatcher("friendManager/removeFriend.jsp");
        dispatcher.forward(req,resp);
    }
}
