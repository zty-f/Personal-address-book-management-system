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

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String nation = req.getParameter("nation");
        String edu = req.getParameter("edu");
        String work = req.getParameter("work");
        String phone = req.getParameter("phone");
        String place = req.getParameter("place");
        String email = req.getParameter("email");

        if (TextUtils.isEmpty(userName)
                || TextUtils.isEmpty(password1)
                || TextUtils.isEmpty(password2)
                || TextUtils.isEmpty(name)
                || TextUtils.isEmpty(sex)
                || TextUtils.isEmpty(year)
                || TextUtils.isEmpty(month)
                || TextUtils.isEmpty(day)
                || TextUtils.isEmpty(nation)
                || TextUtils.isEmpty(edu)
                || TextUtils.isEmpty(work)
                || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(place)
                || TextUtils.isEmpty(email)) {
            resp.sendRedirect("SignUp");
            return;
        }
        if (!password1.equals(password2)) {
            resp.sendRedirect("SignUp");
            return;
        }

        String birth = year + "-" + month + "-" + day;
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password1);
        newUser.setName(name);
        newUser.setSex(sex);
        newUser.setBirth(birth);
        newUser.setNation(nation);
        newUser.setEdu(edu);
        newUser.setWork(work);
        newUser.setPhone(phone);
        newUser.setPlace(place);
        newUser.setEmail(email);

        UserManager manager = new UserManager();
        if (manager.add(newUser)) {
            User user = manager.findUserByUserName(newUser.getUserName());
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getUserName());
            resp.sendRedirect("/main/main.jsp");
        } else {
            resp.sendRedirect("SignUp");
        }
    }
}
