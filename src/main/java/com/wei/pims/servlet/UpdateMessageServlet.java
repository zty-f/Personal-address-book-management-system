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

public class UpdateMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String birth = req.getParameter("birth");
        String nation = req.getParameter("nation");
        String edu = req.getParameter("edu");
        String work = req.getParameter("work");
        String phone = req.getParameter("phone");
        String place = req.getParameter("place");
        String email = req.getParameter("email");

        if (TextUtils.isEmpty(name)
                || TextUtils.isEmpty(sex)
                || TextUtils.isEmpty(birth)
                || TextUtils.isEmpty(nation)
                || TextUtils.isEmpty(edu)
                || TextUtils.isEmpty(work)
                || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(place)
                || TextUtils.isEmpty(email)) {
            String mainUrl = resp.encodeRedirectURL("LookMessageServlet");
            resp.sendRedirect(mainUrl);
        } else {
            UserManager userManager = new UserManager();
            HttpSession session = req.getSession();
            String userName = (String) session.getAttribute("userName");
            User user = userManager.findUserByUserName(userName);
            user.setName(name);
            user.setSex(sex);
            user.setBirth(birth);
            user.setNation(nation);
            user.setEdu(edu);
            user.setWork(work);
            user.setPhone(phone);
            user.setPlace(place);
            user.setEmail(email);
            userManager.modify(user);
            String mainUrl = resp.encodeRedirectURL("LookMessageServlet");
            resp.sendRedirect(mainUrl);
        }
    }
}
