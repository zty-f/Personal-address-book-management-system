package com.wei.pims.dao.daoImpl;

import com.wei.pims.bean.User;
import com.wei.pims.dao.UserDao;
import com.wei.pims.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        User user = null;
        String sql = "SELECT * FROM user WHERE username=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = createUserFromRS(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return user;
    }

    public User select(String username, String password) {
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = createUserFromRS(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return user;
    }

    private User createUserFromRS(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setSex(rs.getString("sex"));
        user.setBirth(rs.getString("birth"));
        user.setNation(rs.getString("nation"));
        user.setEdu(rs.getString("edu"));
        user.setWork(rs.getString("work"));
        user.setPhone(rs.getString("phone"));
        user.setPlace(rs.getString("place"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
