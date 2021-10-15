package com.wei.pims.manager;

import com.wei.pims.bean.Friend;
import com.wei.pims.dao.daoImpl.FriendDaoImpl;

import java.util.List;

public class FriendManager {

    private final FriendDaoImpl friendDao;

    public FriendManager() {
        friendDao = new FriendDaoImpl();
    }
    public boolean add(Friend friend) {
        return friendDao.add(friend);
    }

    public List<Friend> findAll(String userName) {
        return friendDao.findAll(userName);
    }

    public Friend findFriendByName(String userName, String name) {
        return friendDao.findFriendByName(userName,name);
    }

    public boolean modify(Friend friend) {
        return friendDao.update(friend);
    }

    public void remove(String userName, String name) {
        Friend friend = friendDao.findFriendByName(userName,name);
        friendDao.delete(friend);
    }
}
