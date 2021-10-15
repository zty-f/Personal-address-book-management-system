package com.wei.pims.dao;

public interface BaseDao<T> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public T select(T t);
}
