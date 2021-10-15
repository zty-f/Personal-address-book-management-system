package com.wei.pims.dao;

import com.wei.pims.bean.Friend;

import java.util.List;

public interface FriendDao {
    public List<Friend> findAll(String userName);
    public Friend findFriendByName(String userName,String name);
}
