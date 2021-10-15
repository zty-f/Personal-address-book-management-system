package com.wei.pims.servlet;

import com.wei.pims.bean.Friend;
import com.wei.pims.manager.FriendManager;
import com.wei.pims.util.TextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String workplace = req.getParameter("workplace");
        String place = req.getParameter("place");
        String qq = req.getParameter("qq");
        String userName = req.getParameter("userName");

        if (TextUtils.isEmpty(name)
                || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(workplace)
                || TextUtils.isEmpty(place)
                || TextUtils.isEmpty(qq)
                || TextUtils.isEmpty(userName)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("AddFriend");
            dispatcher.forward(req, resp);
        } else {
            Friend friend = new Friend();
            friend.setName(name);
            friend.setPhone(phone);
            friend.setEmail(email);
            friend.setWorkplace(workplace);
            friend.setPlace(place);
            friend.setQq(qq);
            friend.setUserName(userName);
            FriendManager manager = new FriendManager();
            if(manager.add(friend)){
                RequestDispatcher dispatcher = req.getRequestDispatcher("LookFriend");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("AddFriend");
                dispatcher.forward(req, resp);
            }
        }
    }
}
