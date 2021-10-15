package com.wei.pims.dao;

import com.wei.pims.bean.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findUserByUserName(String userName);
}
