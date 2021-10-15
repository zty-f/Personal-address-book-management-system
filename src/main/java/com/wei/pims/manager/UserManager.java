package com.wei.pims.manager;

import com.wei.pims.bean.User;
import com.wei.pims.dao.daoImpl.UserDaoImpl;

public class UserManager {
    private User user;
    private UserDaoImpl userDao = new UserDaoImpl();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean add(User user) {
        return userDao.add(user);
    }

    public void modify(User user) {
        userDao.update(user);
    }

    public void remove(User user) {
        userDao.delete(user);
    }

    public User query(User user) {
        return userDao.select(user);
    }

    public boolean login(String username, String password) {
        User user = userDao.select(username, password);
        setUser(user);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

}
