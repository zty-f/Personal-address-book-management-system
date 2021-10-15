package com.wei.pims.dao.daoImpl;

import com.wei.pims.dao.BaseDao;
import com.wei.pims.util.DBUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;
    private static final String INSERT = "insert";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String SELECT = "select";

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) type.getActualTypeArguments()[0];
    }


    private Object[] getArgs(T entity, String operator) throws IllegalAccessException {
        Field fields[] = entityClass.getDeclaredFields();
        if (INSERT.equals(operator)) {
            Object args[] = new Object[fields.length - 1];
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                args[i - 1] = fields[i].get(entity);
            }
            return args;
        } else if (UPDATE.equals(operator)) {
            Object args[] = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (i == 0) {
                    args[args.length - 1] = fields[i].get(entity);
                } else {
                    args[i - 1] = fields[i].get(entity);
                }
            }
            return args;
        } else if (DELETE.equals(operator)) {
            Object args[] = new Object[1];
            fields[0].setAccessible(true);
            args[0] = fields[0].get(entity);
            return args;
        } else if (SELECT.equals(operator)) {
            Object args[] = new Object[1];
            fields[0].setAccessible(true);
            args[0] = fields[0].get(entity);
            return args;
        }
        return null;
    }


    private String getSql(String operator) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = entityClass.getDeclaredFields();
        if (INSERT.equals(operator)) {
            sb.append("INSERT INTO ");
            sb.append(entityClass.getSimpleName().toLowerCase());
            sb.append(" VALUES (null,");
            for (int i = 1; i < fields.length; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        } else if (UPDATE.equals(operator)) {
            sb.append("UPDATE ");
            sb.append(entityClass.getSimpleName().toLowerCase());
            sb.append(" set ");
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                sb.append(fields[i].getName());
                sb.append("=?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" where id= ?");
        } else if (DELETE.equals(operator)) {
            sb.append("DELETE FROM ");
            sb.append(entityClass.getSimpleName().toLowerCase());
            sb.append(" WHERE id= ? ");
        } else if (SELECT.equals(operator)) {
            sb.append("SELECT * FROM ");
            sb.append(entityClass.getSimpleName().toLowerCase());
            sb.append(" WHERE id=? ");
        }
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        try {
            String sql = getSql(INSERT);
            Object[] args = getArgs(t, INSERT);
            exeSQL(sql, args);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        try {
            String sql = getSql(UPDATE);
            Object[] args = getArgs(t, UPDATE);
            exeSQL(sql, args);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(T t) {
        try {
            String sql = getSql(DELETE);
            Object[] args = getArgs(t, DELETE);
            exeSQL(sql, args);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void exeSQL(String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            DBUtils.setPreparedStatementParams(ps, args);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null, ps, conn);
        }
    }


    @Override
    public T select(T t) {
        String sql = getSql(SELECT);
        System.out.println("select sql=" + sql);
        T obj = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Object[] args = getArgs(t, SELECT);
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            DBUtils.setPreparedStatementParams(ps, args);
            rs = ps.executeQuery();
            Field[] fields = entityClass.getDeclaredFields();
            if (rs.next()) {
                obj = entityClass.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    fields[i].set(obj, rs.getObject(fields[i].getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return obj;
    }
}
