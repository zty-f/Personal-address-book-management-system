package com.wei.pims.dao.daoImpl;

import com.wei.pims.bean.Friend;
import com.wei.pims.dao.FriendDao;
import com.wei.pims.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImpl extends BaseDaoImpl<Friend> implements FriendDao {
    @Override
    public Friend findFriendByName(String userName, String name) {
        String sql = "SELECT * FROM friend where userName=? and name=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Friend friend = null;
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            ps.setString(1, userName);
            ps.setString(2,name);
            rs = ps.executeQuery();
            if (rs.next()) {
                friend = createFriendFromRS(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return friend;
    }

    @Override
    public List<Friend> findAll(String userName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Friend> friends = new ArrayList<>();
        String sql = "SELECT * FROM friend where userName=?";
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Friend friend = createFriendFromRS(rs);
                friends.add(friend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return friends;

    }

    private Friend createFriendFromRS(ResultSet rs) throws SQLException {
        Friend friend = new Friend();
        friend.setId(rs.getInt("id"));
        friend.setUserName(rs.getString("userName"));
        friend.setName(rs.getString("name"));
        friend.setPhone(rs.getString("phone"));
        friend.setEmail(rs.getString("email"));
        friend.setWorkplace(rs.getString("workplace"));
        friend.setPlace(rs.getString("place"));
        friend.setQq(rs.getString("qq"));
        return friend;
    }
}
